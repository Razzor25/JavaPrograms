{
  "compileOnSave": false,
  "compilerOptions": {
    "rootDir": ".",
    "sourceMap": true,
    "declaration": false,
    "strictNullChecks": true,
    "moduleResolution": "node",
    "emitDecoratorMetadata": true,
    "experimentalDecorators": true,
    "importHelpers": true,
    "target": "es2020",
    "module": "esnext",
    "lib": ["es2020", "dom"],
    "skipLibCheck": true,
    "esModuleInterop": true,
    "skipDefaultLibCheck": true,
    "baseUrl": ".",
    "types": ["node"],
    "paths": {
      "@angular/*": ["node_modules/@angular/*"],
      "@ecp/optumcare-nx-component-library.data-access-adt-view": ["libs/data-access-adt-view/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-alternative-contact-details": [
        "libs/data-access-alternative-contact-details/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-authdata": ["libs/data-access-authdata/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-cancellable-operation": [
        "libs/data-access-cancellable-operation/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-care-management-assignment": [
        "libs/data-access-care-management-assignment/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-care-management-note": [
        "libs/data-access-care-management-note/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-conditions": ["libs/data-access-conditions/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-environment": ["libs/data-access-environment/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-file-upload": ["libs/data-access-file-upload/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-file-upload-communication": [
        "libs/data-access-file-upload-communication/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-graphql": ["libs/data-access-graphql/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-hsc": ["libs/data-access-hsc/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-individual": ["libs/data-access-individual/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-individual-address": [
        "libs/data-access-individual-address/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-demographic-update": [
        "libs/data-access-individual-demographic-update/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-details": [
        "libs/data-access-individual-details/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-email-data-update": [
        "libs/data-access-individual-email-data-update/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-health-record": [
        "libs/data-access-individual-health-record/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-key": [
        "libs/data-access-individual-key/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-phone-data-update": [
        "libs/data-access-individual-phone-data-update/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-preference": [
        "libs/data-access-individual-preference/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-individual-relation": [
        "libs/data-access-individual-relation/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-interaction-tooltip": [
        "libs/data-access-interaction-tooltip/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-internal-user-search": [
        "libs/data-access-internal-user-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-manage-adt-view": [
        "libs/data-access-manage-adt-view/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-member-index-sync": [
        "libs/data-access-member-index-sync/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-member-program": [
        "libs/data-access-member-program/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-member-roster": ["libs/data-access-member-roster/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-member-search": ["libs/data-access-member-search/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-oc-activity-bar": [
        "libs/data-access-oc-activity-bar/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-oc-custom-date": [
        "libs/data-access-oc-custom-date/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-oc-member-search": [
        "libs/data-access-oc-member-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-personalization": [
        "libs/data-access-personalization/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-provider": ["libs/data-access-provider/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-provider-directory-search": [
        "libs/data-access-provider-directory-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-provider-search": [
        "libs/data-access-provider-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-reference-data": [
        "libs/data-access-reference-data/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-search-index": ["libs/data-access-search-index/src/index.ts"],
      "@ecp/optumcare-nx-component-library.data-access-token-generation": [
        "libs/data-access-token-generation/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-type-ahead-search": [
        "libs/data-access-type-ahead-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.data-access-work-queue-mgmt": [
        "libs/data-access-work-queue-mgmt/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.feature-adt-view": ["libs/feature-adt-view/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-auth-details": ["libs/feature-auth-details/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-care-team": ["libs/feature-care-team/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-file-upload": ["libs/feature-file-upload/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-interactions-grid": ["libs/feature-interactions-grid/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-manage-adt-view": ["libs/feature-manage-adt-view/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-member-conditions": ["libs/feature-member-conditions/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-member-data": ["libs/feature-member-data/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-member-demographics": [
        "libs/feature-member-demographics/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.feature-navi-health": ["libs/feature-navi-health/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-oc-member-search": ["libs/feature-oc-member-search/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-provider-directory": [
        "libs/feature-provider-directory/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.feature-user-roster": ["libs/feature-user-roster/src/index.ts"],
      "@ecp/optumcare-nx-component-library.feature-work-queue-details": [
        "libs/feature-work-queue-details/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.feature-work-queue-summary": [
        "libs/feature-work-queue-summary/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.plugins": ["plugins/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-demo": ["libs/ui-demo/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-file-upload": ["libs/ui-file-upload/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-in-progress-interactions": [
        "libs/ui-in-progress-interactions/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.ui-label-value": ["libs/ui-label-value/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-member-summary-notes": ["libs/ui-member-summary-notes/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-menu-popover": ["libs/ui-menu-popover/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-simple-accordion": ["libs/ui-simple-accordion/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-site-selection": ["libs/ui-site-selection/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-status-ring": ["libs/ui-status-ring/src/index.ts"],
      "@ecp/optumcare-nx-component-library.ui-user-profile": ["libs/ui-user-profile/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-adt-interfaces": ["libs/util-adt-interfaces/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-alternate-contact-details-models": [
        "libs/util-alternate-contact-details-models/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-auth-interfaces": ["libs/util-auth-interfaces/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-azure-search-interfaces": [
        "libs/util-azure-search-interfaces/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-care-team-models": ["libs/util-care-team-models/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-adhoc-interactions": [
        "libs/util-constants-adhoc-interactions/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-adt": ["libs/util-constants-adt/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-auth-enums": ["libs/util-constants-auth-enums/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-auth-status": [
        "libs/util-constants-auth-status/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-care-management": [
        "libs/util-constants-care-management/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-care-management-domain-tables": [
        "libs/util-constants-care-management-domain-tables/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-care-team-secondary": [
        "libs/util-constants-care-team-secondary/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-common": ["libs/util-constants-common/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-config": ["libs/util-constants-config/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-date-format-enums": [
        "libs/util-constants-date-format-enums/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-endpoints": ["libs/util-constants-endpoints/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-facility-search": [
        "libs/util-constants-facility-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-individual": ["libs/util-constants-individual/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-individual-health-profile": [
        "libs/util-constants-individual-health-profile/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-indv-domain-tables": [
        "libs/util-constants-indv-domain-tables/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-indv-health-profile-tables": [
        "libs/util-constants-indv-health-profile-tables/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-intake-source": [
        "libs/util-constants-intake-source/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-interaction": [
        "libs/util-constants-interaction/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-member": ["libs/util-constants-member/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-member-snapshot-config": [
        "libs/util-constants-member-snapshot-config/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-notes": ["libs/util-constants-notes/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-notice-of-determination-call": [
        "libs/util-constants-notice-of-determination-call/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-practice-manager": [
        "libs/util-constants-practice-manager/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-provider-directory": [
        "libs/util-constants-provider-directory/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-provider-search": [
        "libs/util-constants-provider-search/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-query": ["libs/util-constants-query/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-ref-domain-tables": [
        "libs/util-constants-ref-domain-tables/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-reference-data": [
        "libs/util-constants-reference-data/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-request-information": [
        "libs/util-constants-request-information/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-constants-role": ["libs/util-constants-role/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-constants-storage-events": [
        "libs/util-constants-storage-events/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-date": ["libs/util-date/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-date-pipe": ["libs/util-date-pipe/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-file": ["libs/util-file/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-http": ["libs/util-http/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-menu-popover": ["libs/util-menu-popover/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-oc-member-search": ["libs/util-oc-member-search/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-provider-directory-interfaces": [
        "libs/util-provider-directory-interfaces/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-reference-data-models": [
        "libs/util-reference-data-models/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-string": ["libs/util-string/src/index.ts"],
      "@ecp/optumcare-nx-component-library.util-super-community-interface": [
        "libs/util-super-community-interface/src/index.ts"
      ],
      "@ecp/optumcare-nx-component-library.util-test-helpers": ["libs/util-test-helpers/src/index.ts"],
      "@ecp/storybook-angular": ["storybook/storybook-angular/src/index.ts"]
    }
  },
  "exclude": ["node_modules", "tmp"]
}
