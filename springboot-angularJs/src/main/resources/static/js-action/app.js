/**
 *  模块和路由定义
 */

var actionApp = angular.module('actionApp',['ngRoute']); //定义模块actionApp，并依赖路由模块ngRoute
actionApp.config(['$routeProvider',function ($routeProvider) { //配置路由，并注入$routeProvider来配置
    $routeProvider.when('/oper',{ // /oper是路由名称
        controller : 'View1Controller', // controller定义路由的控制器名称
        templateUrl : 'views/view1.html'   //templateUrl 定义视图的真正地址
    }).when('/directive', { // /oper是路由名称
        controller: 'View2Controller',
        templateUrl: 'views/view2.html'
    }).when('/other', { // /oper是路由名称
        templateUrl: 'views/home.html'
    }).otherwise('/other');
}]);

//访问地址：https://localhost/action.html#!/oper