/** 
Note: Following are the conditions for each page at powerbi end , on top of this query.

InProgress Tab :
Main{Distributeddatetime is null and inprogress_status is "Yes" }

Failed Tab :
failed_status is "Yes"

Success tab :
success_status is "Yes"

Disbursment delayed tab : 
Main{Distributeddatetime is null and disbursed_status is "Yes" }

**/


---main query

SELECT 
matrdelmethod.mbr_cmnct_atr_val::text,
	msbjhscid.mbr_cmnct_sbj_typ_ref_id,
m.mbr_cmnct_id AS membercommunicationid,
mbrcorrelkey.mbr_cmnct_key_val AS lettertrackingid,
mcscsts.mbr_cmnct_sts_ref_id,
msbjhscid.mbr_cmnct_sbj_id AS hscid,
msbj.mbr_cmnct_sbj_id AS memberid,
RTRIM(split_part(mcscsts.commt_txt, ':\"',4),'\"}]') error_details,
concat(mcscsts.mbr_cmnct_sts_ref_id,': ',mcrsts.ref_desc) status_msg,
mcsinteractionid.mbr_cmnct_sbj_id as interaction,
timezone('US/Central',mcscsts.sts_dttm::timestamptz) AS sts_dttm,
mcstemplatename.mbr_cmnct_atr_val AS templatename,
mcscreceived.sts_dttm::timestamp::date as test_date,
timezone('US/Central',m.creat_dttm::timestamptz) AS createdatetime,
timezone('US/Central',mcscgenerate.sts_dttm::timestamptz) AS generatedatetime,
timezone('US/Central',mcscprint.sts_dttm::timestamptz)  AS printdatetime,
case 
    when (mcscsts.mbr_cmnct_sts_ref_id in (25107,24805,25970/*(previously 25064)*/,25930)) 
	    or (upper(matrdelmethod.mbr_cmnct_atr_val::text) 
			= 'EDELIVERY'::text and mcscsts.mbr_cmnct_sts_ref_id=25975/*previously 25062*/) 
		and mcscreceived.sts_dttm is null 
	then timezone('US/Central',mcscgenerate.sts_dttm::timestamptz)
	else timezone('US/Central',mcscreceived.sts_dttm::timestamptz)
	end as receiveddatetime,
CASE
    WHEN upper(matrdelmethod.mbr_cmnct_atr_val::text) = 'EDELIVERY'::text 
	THEN timezone('US/Central',mcscprint.sts_dttm::timestamptz)
    ELSE timezone('US/Central',mcscdistributed.sts_dttm::timestamptz)
    END AS distributeddatetime,
CASE
    WHEN upper(matrdelmethod.mbr_cmnct_atr_val::text) = 'EDELIVERY'::text 
	THEN timezone('US/Central',mcscprint.sts_dttm::timestamptz)
    ELSE timezone('US/Central',mcscopssent.sts_dttm::timestamptz)
    END AS sentdatetime,
matrdelmethod.mbr_cmnct_atr_val AS deliverymethod,
mcsrequestedurgencyofmailing.mbr_cmnct_sbj_id AS urgencyofmailing,
mcscvendor.mbr_cmnct_sbj_id AS vendorname,
mcscvendortrack.mbr_cmnct_sbj_id AS vendorlettertrackingid,
case 
    when to_char( timezone('US/Central', mcscreceived.sts_dttm::timestamptz), 'Day') ilike '%Saturday%' 
	or to_char( timezone('US/Central', mcscreceived.sts_dttm::timestamptz), 'Day') ilike '%Sunday%' then 'True'
	else 'False'
    end as requested_on_holiday,
r.ref_dspl as Recipient,
mcsworkgrp.mbr_cmnct_sbj_id AS workgroupname,
	case when mcscsts.mbr_cmnct_sts_ref_id in (24804,25060,25962,25975,25972,25973,25988,25989) 
                           And upper(matrdelmethod.mbr_cmnct_atr_val::text) <>  'EDELIVERY'::text  then 'Yes' 
	     when upper(matrdelmethod.mbr_cmnct_atr_val::text) = 'EDELIVERY'::text and mcscsts.mbr_cmnct_sts_ref_id=25975/*earlier 25062*/ then 'No'
		 else 'No' end as inprogress_status,
	case when mcscsts.mbr_cmnct_sts_ref_id in (25107,24805,25970,25930) then 'Yes'
	     when upper(matrdelmethod.mbr_cmnct_atr_val::text) = 'EDELIVERY'::text and mcscsts.mbr_cmnct_sts_ref_id=25975/*earlier 25062*/ then 'Yes'
	     else 'No' end as success_status,
	case when mcscsts.mbr_cmnct_sts_ref_id not in (24804,24805,25060,25962,25975,25972,25970,25973,25107,25092,25988,25989) then 'Yes'
	     when msbjhscid.mbr_cmnct_sbj_typ_ref_id in( 25045) and mcscsts.mbr_cmnct_sts_ref_id = 25930 then 'Yes'
		 when mcscsts.mbr_cmnct_sts_ref_id = 25990 then 'Yes'
		 else 'No' end as failed_status,
	case when (EXTRACT(EPOCH from (now() at time zone 'utc' - mcscreceived.sts_dttm)) > 7200 and upper(mcrsts.ref_desc) like '%RIGHTFAX%')
		or (EXTRACT(EPOCH from (now() at time zone 'utc' - mcscreceived.sts_dttm)) > 600 and matrdelmethod.mbr_cmnct_atr_val = 'Edelivery')
	or (EXTRACT(EPOCH from (now() at time zone 'utc' - mcscreceived.sts_dttm)) > 259200 
		and mcscsts.mbr_cmnct_sts_ref_id <> ANY (ARRAY[24804, 24805, 24806, 24810]) and
 (lower(mcrsts.ref_desc) like '%letter is sent or mailed%'))
		or (EXTRACT(EPOCH from (now() at time zone 'utc' - mcscreceived.sts_dttm)) > 108000 and upper(mcrsts.ref_desc) like '%OPS%'
		and mcscsts.mbr_cmnct_sts_ref_id = ANY (ARRAY[24804, 24805, 24806, 24810]))
		then 'Yes' else 'No' end as disbursed_status
   FROM mbr_cmnct m
   LEFT JOIN mbr_cmnct_sbj mcsworkgrp ON m.mbr_cmnct_id = mcsworkgrp.mbr_cmnct_id AND mcsworkgrp.mbr_cmnct_sbj_typ_ref_id = 25040
     LEFT JOIN mbr_cmnct_sts_chg mcscreceived ON m.mbr_cmnct_id = mcscreceived.mbr_cmnct_id AND mcscreceived.mbr_cmnct_sts_ref_id = 27020
     LEFT JOIN mbr_cmnct_prtcp mprtcp ON m.mbr_cmnct_id = mprtcp.mbr_cmnct_id
	 left join mbr_cmnct_ref r on r.ref_id = mprtcp.mbr_cmnct_prtcp_role_ref_id
     LEFT JOIN mbr_cmnct_sbj msbj ON m.mbr_cmnct_id = msbj.mbr_cmnct_id AND (msbj.mbr_cmnct_sbj_typ_ref_id = ANY (ARRAY[25047,20783,25046]))
     LEFT JOIN mbr_cmnct_sbj msbjhscid ON m.mbr_cmnct_id = msbjhscid.mbr_cmnct_id AND msbjhscid.mbr_cmnct_sbj_typ_ref_id = 25045
     LEFT JOIN mbr_cmnct_key mbrcorrelkey ON m.mbr_cmnct_id = mbrcorrelkey.mbr_cmnct_id AND mbrcorrelkey.mbr_cmnct_key_typ_ref_id = 25052
     LEFT JOIN mbr_cmnct_ref mcrsts ON m.mbr_cmnct_sts_ref_id = mcrsts.ref_id
     LEFT JOIN mbr_cmnct_sts_chg mcscprint ON m.mbr_cmnct_id = mcscprint.mbr_cmnct_id 
	 AND mcscprint.mbr_cmnct_sts_ref_id=25975/*previously 25062*/
     LEFT JOIN mbr_cmnct_atr mcstemplatename ON m.mbr_cmnct_id = mcstemplatename.mbr_cmnct_id AND mcstemplatename.mbr_cmnct_atr_typ_ref_id = 25041
     LEFT JOIN mbr_cmnct_atr matrdelmethod ON m.mbr_cmnct_id = matrdelmethod.mbr_cmnct_id AND matrdelmethod.mbr_cmnct_atr_typ_ref_id = 25042
     LEFT JOIN LATERAL ( SELECT stslateral.mbr_cmnct_id,
     stslateral.mbr_cmnct_sts_ref_id,
     stslateral.sts_dttm,
     row_number() OVER (PARTITION BY stslateral.mbr_cmnct_id ORDER BY stslateral.sts_dttm DESC) AS rowno
     FROM mbr_cmnct_sts_chg stslateral
     WHERE stslateral.mbr_cmnct_sts_ref_id in (24804,25972/*earlier 25063*/,25973/*earlier 25106*/)
						AND stslateral.mbr_cmnct_id = m.mbr_cmnct_id) mcscopssent 
						ON m.mbr_cmnct_id = mcscopssent.mbr_cmnct_id AND mcscopssent.rowno = 1
     LEFT JOIN mbr_cmnct_sts_chg mcscdistributed ON m.mbr_cmnct_id = mcscdistributed.mbr_cmnct_id 
	 AND mcscdistributed.mbr_cmnct_sts_ref_id in(25970/*earlier 25064*/,25107,24805,26988)
     LEFT JOIN mbr_cmnct_sbj mcscvendor ON m.mbr_cmnct_id = mcscvendor.mbr_cmnct_id AND mcscvendor.mbr_cmnct_sbj_typ_ref_id = 25056
     LEFT JOIN mbr_cmnct_sbj mcscvendortrack ON m.mbr_cmnct_id = mcscvendortrack.mbr_cmnct_id AND mcscvendortrack.mbr_cmnct_sbj_typ_ref_id = 25057
     LEFT JOIN mbr_cmnct_sbj mcsinteractionid ON m.mbr_cmnct_id = mcsinteractionid.mbr_cmnct_id AND mcsinteractionid.mbr_cmnct_sbj_typ_ref_id = 24850
     LEFT JOIN mbr_cmnct_sbj mcsrequestedurgencyofmailing ON m.mbr_cmnct_id = mcsrequestedurgencyofmailing.mbr_cmnct_id AND mcsrequestedurgencyofmailing.mbr_cmnct_sbj_typ_ref_id = 24852
     LEFT JOIN LATERAL ( SELECT stslateral2.mbr_cmnct_id,
            stslateral2.mbr_cmnct_sts_ref_id,commt_txt,sts_dttm,
            row_number() OVER (PARTITION BY stslateral2.mbr_cmnct_id ORDER BY stslateral2.sts_dttm DESC) AS rowno
           FROM mbr_cmnct_sts_chg stslateral2
          WHERE stslateral2.mbr_cmnct_sts_ref_id not in (25092)	
         AND stslateral2.mbr_cmnct_id = m.mbr_cmnct_id) mcscsts ON m.mbr_cmnct_id = mcscsts.mbr_cmnct_id AND mcscsts.rowno = 1
	LEFT JOIN LATERAL ( SELECT mbr_cmnct_sts_chg.mbr_cmnct_id,
            mbr_cmnct_sts_chg.mbr_cmnct_sts_ref_id,
            mbr_cmnct_sts_chg.sts_dttm,
            row_number() OVER (PARTITION BY mbr_cmnct_sts_chg.mbr_cmnct_id ORDER BY mbr_cmnct_sts_chg.sts_dttm DESC) AS rowno
           FROM mbr_cmnct_sts_chg
          WHERE mbr_cmnct_sts_chg.mbr_cmnct_sts_ref_id = 25962/*previously 25061*/ 
		  AND mbr_cmnct_sts_chg.mbr_cmnct_id = m.mbr_cmnct_id) mcscgenerate ON m.mbr_cmnct_id = mcscgenerate.mbr_cmnct_id 
		  AND mcscgenerate.rowno = 1
 WHERE mcstemplatename.mbr_cmnct_atr_val in ('CEQ_Pharmacy_Coversheet','CEQ_MedAdherence_Coversheet')
and msbjhscid.mbr_cmnct_sbj_id is null --for cm letters
and timezone('US/Central',m.creat_dttm) >= timezone('US/Central',current_date) - interval '3 month'
and (upper(matrdelmethod.mbr_cmnct_atr_val::text) <> 'TESTONLY' or upper(matrdelmethod.mbr_cmnct_atr_val::text) is null)
and m.mbr_cmnct_catgy_ref_id in (20700, 20701, 20715, 20747, 20753, 74006) -- for getting only 2.0 letters


---super community

select distinct indv.indv_id, super_community
From cdcm_mbr.patient p
join public.indv on p.patient_sk =indv.caredata_mbr_id ::bigint
join cdcm_mbr.eligibility e on p.patient_sk = e.patient_sk and p.source_system_sk = e.source_system_sk
join cdcm_mbr.pod pd ON pd.pod_sk=e.pod_sk
WHERE p.patient_sk > 0 and indv.indv_id>0
and e.del_ind = 0
and e.benefit_plan_effective_dt <=current_date
and (e.benefit_plan_term_dt > current_date or e.benefit_plan_term_dt is null) 


--- cm interactions & org 

select cma.org_id,cmaa.care_mgt_asgn_atr_val,asgn_sts_ref_id, asgn_otcome_ref_id,cli.org_nm
from care_mgt_asgn_atr cmaa 
join care_mgt_asgn cma on cma.care_mgt_asgn_id = cmaa.care_mgt_asgn_id 
join care_mgt_cli_org_mv cli on cma.org_id=cli.cli_org_id
where cmaa.care_mgt_asgn_atr_ref_id= 1001098


---user details for cdo restriction

select distinct u.USER_ID,cli_org_id,fr.func_role_nm,
 u.USER_ID||'-'||func_role_nm user_func
from 
user_tbl u left join user_cli_func_role fr
                  ON        fr.user_id = u.user_id
where 
( fr.end_dt is  null or  fr.end_dt>current_date)


----mbr prov db data for org configurations , timezone conversions

select indv_id,i.org_id,org_nm,
case  when org.timezonename_refresh= 'All Timestamps are in Eastern Time Zone' then '+1'
							  when org.timezonename_refresh= 'All Timestamps are in Pacific Time Zone'  then '-2'
							  when org.timezonename_refresh='All Timestamps are in Mountain Time Zone'  then '-1'
							  when org.timezonename_refresh='All Timestamps are in Central Time Zone'   then '+0'
							  end as hours_diff
from indv i join 
 mbr_prov_org_configurations org on org.org_id=i.org_id
 join indv_cli_org o on i.org_id=o.cli_org_id
where indv_id>0 


