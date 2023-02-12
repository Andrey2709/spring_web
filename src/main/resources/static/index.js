angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8084/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

 $scope.addProductToBascket = function(productId){
        $http.get(contextPath + '/products/add/'+ productId)
            .then(function(response){

            console.log(response.data)

                $scope.productListBasket = response.data
            });
    };




//    $scope.changeScore = function (clientId, delta){
//        $http({
//            url: contextPath + '/client/change_score',
//            method: 'GET',
//            params: {
//                clientId: clientId,
//                delta: delta
//            }
//        }).then(function (response){
//            $scope.loadClients();
//        });
//    };loadClients

    $scope.loadProducts();

});