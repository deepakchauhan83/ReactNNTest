/**
 * @format
 */

import { Navigation } from "react-native-navigation";
// import {AppRegistry} from 'react-native';
import App from './App';
import ProductList from './ProductList';
// import {name as appName} from './app.json';

// AppRegistry.registerComponent(appName, () => App);

Navigation.registerComponent(`reactnn.test.WelcomeScreen`, () => App);
Navigation.registerComponent(`product.list`, () => ProductList);


Navigation.events().registerAppLaunchedListener(() => {
      Navigation.setRoot({
        root: {
          stack: {
            options: {
              topBar: {
                visible: false
              }
            },
            children: [
              {
                component: {
                  name: 'reactnn.test.WelcomeScreen',
                  passProps: {
                    text: 'This is Welcome Screen',
                  }
                }
              }
            ]
          }
        }
      });
});