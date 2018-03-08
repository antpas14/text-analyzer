var app = angular.module('ssk-fe',[]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {

    $scope.data = ''
    $scope.pattern = ''
    $scope.table_content = [];
    $scope.reply = {}
    $scope.reply.wordCount = '-'
    $scope.reply.wordLength = '-'
    $scope.reply.charactersNumber = '-'
    $scope.reply.charactersFromPattern = '-'
    $scope.reply.wordsFromPattern = '-'
    $scope.title = "Text analyzer"

    $scope.calculate = function() {
        var hostname = window.location.hostname;
        var data = {}
        data["data"] = $scope.data
        data["pattern"] = $scope.pattern.split(" ")

        console.log("DATA IS ", data)
        console.log($scope.data)
        console.log($scope.pattern)

        // console.log("HTTP IS ", $http)
        // $http.post('/calculate', data).then($scope.calculateSuccess);
        $http({
            method: 'POST',
            url: "http://" + hostname + ":8081/getMetadata",
            data: JSON.stringify(data),
            headers: {'Content-Type': 'application/json'}
        }).then(function(response) {
            $scope.reply.wordCount = response.data.wordCount
            $scope.reply.wordLength = response.data.wordLength
            $scope.reply.charactersNumber = response.data.charactersNumber
            $scope.reply.wordsFromPattern = response.data.wordsFromPattern
            $scope.reply.charactersFromPattern = response.data.charactersFromPattern

            console.log($scope.reply)
        })
    }



}]);
