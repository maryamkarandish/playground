<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    var app = angular.module("app", ["ngRoute"]);
    app.controller('appController', function AppController ($scope, $rootScope) {

    });

    app.controller('getPercentageOfUsageReportController', function($scope) {
        $scope.getPercentageOfUsageReport = function() {
            var request = $.ajax({
                type: "get",
                contentType: "application/json; charset=utf-8",
                url: '<c:url value="/getPercentageOfUsageReport"/>'
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });
            });
        };
    });

    app.controller('fetchLogReportController', function($scope) {
        $scope.getPercentageOfUsageReport = function() {
            var request = $.ajax({
                type: "get",
                contentType: "application/json; charset=utf-8",
                url: '<c:url value="/fetchLog"/>'
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });
            });
        };
    });



    function showKidList(scope) {
        var request = $.ajax({
            type: "get",
            contentType: "application/json; charset=utf-8",
            url: '<c:url value="/showKidList"/>'
        });

        request.done(function (data, textStatus, jqXHR) {
            scope.$apply(function(){
                scope.kidList = data;
            });
        });
    }

    function showEquipmentList(scope) {
        var request = $.ajax({
            type: "get",
            contentType: "application/json; charset=utf-8",
            url: '<c:url value="/showEquipmentList"/>'
        });

        request.done(function (data, textStatus, jqXHR) {
            scope.$apply(function(){
                scope.equipmentList = data;
            });
        });
    }
</script>
<jsp:include page="addQueueController.inc.jsp" />
<jsp:include page="enterKidController.inc.jsp" />
<jsp:include page="playgroundSiteConfigurationController.inc.jsp" />
<jsp:include page="startController.inc.jsp" />