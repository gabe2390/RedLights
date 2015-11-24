'use strict';

/**
 * @ngdoc overview
 * @name redLightFrontApp
 * @description
 * # redLightFrontApp
 *
 * Main module of the application.
 */
angular
  .module('redLightApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'redlightApp.controllers',
    'redlightApp.services',
    'redlightApp.directives'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/view1.html',
        controller: 'redlightCtrl',
      })
      .when('/view2', {
        templateUrl: 'views/view2.html',
        controller: 'redlightCtrl',
      })
      .otherwise({
        redirectTo: 'views/view1'
      });
  });