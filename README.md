import type { StorybookConfig } from '@storybook/angular';
import webpack from 'webpack';
import { merge } from 'webpack-merge';

const customConfig: webpack.Configuration = {
  devtool: 'source-map',
  resolve: {
    alias: {
      '@themes': '@ecp/angular-ui-component-library/themes',
    },
  },
  module: {
    rules: [],
  },
};

const config: StorybookConfig = {
  docs: {
    autodocs: true,
  },
  stories: [
    '../../../libs/**/*.stories.mdx',
    '../../../libs/**/*.stories.@(js|jsx|ts|tsx)',
  ],
  addons: [
    '@storybook/addon-essentials',
    '@storybook/addon-interactions',
    '@ecp/netra-storybook-addon-library/theme-switcher',
    '@storybook/addon-links',
    '@storybook/addon-a11y',
    '@storybook/addon-styling',
    '@storybook/addon-themes',
    'manager',
  ],
  framework: {
    name: '@storybook/angular',
    options: {},
  },
  webpackFinal: async (config: webpack.Configuration): Promise<webpack.Configuration> => {
    return merge(config, customConfig);
  },
};

export default config;






error:


ERROR in storybook/storybook-angular/.storybook/main.ts:39:3 - error TS2322: Type '(config: webpack.Configuration) => Promise<webpack.Configuration>' is not assignable to type '(config: Configuration, options: Options) => Configuration | Promise<Configuration>'.
  Types of parameters 'config' and 'config' are incompatible.
    Type 'import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/.pnpm/webpack@5.91.0_@swc+core@1.3.107_esbuild@0.18.20/node_modules/webpack/types").Configuration' is not assignable to type 'import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/webpack/types").Configuration'.
      Types of property 'entry' are incompatible.
        Type 'string | string[] | (() => string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/.pnpm/webpack@5.91.0_@swc+core@1.3.107_esbuild@0.18.20/node_modules/webpack/types").EntryObject | Promise<...>) | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/n...' is not assignable to type 'string | string[] | (() => string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/webpack/types").EntryObject | Promise<EntryStatic>) | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/webpack/types").EntryObject | undefined'.
          Type '() => string | string[] | EntryObject | Promise<EntryStatic>' is not assignable to type 'string | string[] | (() => string | string[] | EntryObject | Promise<EntryStatic>) | EntryObject | undefined'.
            Type '() => string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/.pnpm/webpack@5.91.0_@swc+core@1.3.107_esbuild@0.18.20/node_modules/webpack/types").EntryObject | Promise<...>' is not assignable to type '() => string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/webpack/types").EntryObject | Promise<EntryStatic>'.
              Type 'string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/.pnpm/webpack@5.91.0_@swc+core@1.3.107_esbuild@0.18.20/node_modules/webpack/types").EntryObject | Promise<...>' is not assignable to type 'string | string[] | import("/Users/sroy142/Documents/GitHub/optumcare-nx-component-library/node_modules/webpack/types").EntryObject | Promise<EntryStatic>'.
                Type 'EntryObject' is not assignable to type 'string | string[] | EntryObject | Promise<EntryStatic>'.
                  Type 'EntryObject' is missing the following properties from type 'string[]': length, pop, push, concat, and 29 more.

39   webpackFinal: async (config: webpack.Configuration): Promise<webpack.Configuration> => {
     ~~~~~~~~~~~~

  node_modules/.pnpm/@storybook+builder-webpack5@7.6.17_@swc+helpers@0.5.8_esbuild@0.18.20_typescript@4.8.4/node_modules/@storybook/builder-webpack5/dist/index.d.ts:29:5
    29     webpackFinal?: (config: Configuration, options: Options) => Configuration | Promise<Configuration>;
           ~~~~~~~~~~~~
    The expected type comes from property 'webpackFinal' which is declared here on type 'StorybookConfig'

preview compiled with 1 error






FATA::
=> Failed to build the preview
99% end closing watch compilationWARN Force closed preview build
SB_BUILDER-WEBPACK5_0003 (WebpackCompilationError): There were problems when compiling your code with Webpack.
Run Storybook with --debug-webpack for more information.
    at starter (./node_modules/.pnpm/@storybook+builder-webpack5@7.6.17_@swc+helpers@0.5.8_esbuild@0.18.20_typescript@4.8.4/node_modules/@storybook/builder-webpack5/dist/index.js:1:9660)
    at starter.next (<anonymous>)
    at Module.start (./node_modules/.pnpm/@storybook+builder-webpack5@7.6.17_@swc+helpers@0.5.8_esbuild@0.18.20_typescript@4.8.4/node_modules/@storybook/builder-webpack5/dist/index.js:1:11692)
    at process.processTicksAndRejections (node:internal/process/task_queues:95:5)

WARN Could not resolve addon "manager", skipping. Is it installed?

 NX   Broken build, fix the error above.

You may need to refresh the browser.


—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

 NX   Ran target storybook for project storybook-angular (2m)

   ✖  1/1 failed
   ✔  0/1 succeeded [0 read from cache]




