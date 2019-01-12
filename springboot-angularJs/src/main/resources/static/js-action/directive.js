actionApp.directive('datePicker',function () {
    return {
        restrict : 'AC',
        link : function (scope,elem,attrs) {  //使用link方法来定义指令，在link发放内，可使用当前scope，当前元素，当前属性
           console.log(scope);
            alert("自定义指令");
        }
    }
});
