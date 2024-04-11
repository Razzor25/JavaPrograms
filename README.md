CREATE VIEW qom_workqueue_summary
AS 
SELECT 
ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) as view_id,
wq.workqueue_id, wq.workqueue_name, int.org_id,
count(int.interaction_id) as cdo_based_tasks,
SUM(count(int.interaction_id)) OVER (PARTITION BY wq.workqueue_id) as total_tasks
from public.workqueue wq 
JOIN public.qom_interactions int on wq.workqueue_id=int.workqueue_id
WHERE int.int_status_id IN (1000882,1000936) 
GROUP by (wq.workqueue_id,int.org_id);
-- Here 1000882 and 1000936 is INPROGRESS AND SCHEDULED STATUS of INTERACTIONS 
