/**
 * 控制器 定义
 */
// 1 定义view1Controller，并注入$Scope,$rootScope,$http
actionApp.controller('View1Controller',['$rootScope','$scope','$http',function ($rootScope,$scope,$http) {

    //2 使用$Scope.$on监听$viewContentLoaded事件，可以在页面内容加载完后，进行一些操作。
    $scope.$on('$viewContentLoaded',function () {
        console.log("页面加载完成");
    });

    //3 核心代码，结合view1页面
   /* $scope.search  = function () { //3.1 在Scope内定义一个方法search,在页面上通过ng-click调用。
        personName = $scope.personName; //3.2  通过$Scope.personName 获取页面定义的 ng-model="personName"的值
        $http.get('search',{ //3.3  使用$http.get向服务端地址 search 发送get请求。
            params : {personName:personName} //3.4 使用params 增加请求参数
        }).success(function (data) { //3.5 用success方法作为请求成功后的回调
            $scope.person = data;
            //3.6  将服务端返回数据data 通过$Scope.person 赋给模型 person，这样页面视图上可以通过 {{person.name}},
            // {{person.age}}来调用，且模型person的值改变后，视图是自动更新的。
        });
    };*/

    //新版本的AngularJs中取消了success和error，用promise规则。
    //修改
    $scope.search  = function () { //3.1 在Scope内定义一个方法search,在页面上通过ng-click调用。
        personName = $scope.personName; //3.2  通过$Scope.personName 获取页面定义的 ng-model="personName"的值
        $http.get('search', {
            params: {personName:personName}
        }).then(function (result) {  //正确请求成功时处理
            alert(result.data);
            $scope.person = result.data;
        }).catch(function (result) { //捕捉错误处理
            console.info(result);
        });
    };

    
}]);


actionApp.controller('View2Controller',['$rootScope','$scope',function ($rootScope,$scope) {

    $scope.$on('$viewContentLoaded',function () {
        console.log("页面加载完成");
    });
}]);