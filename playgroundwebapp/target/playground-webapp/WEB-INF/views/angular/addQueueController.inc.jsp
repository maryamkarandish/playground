<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    app.controller('addQueueController', function($scope){
        $scope.showEquipmentList = showEquipmentList($scope);
        $scope.showKidList = showKidList($scope);

        $scope.addQueue = function() {
            var data = { equipmentId: findEquipment(), ticketNo: $("#kid").val() };

            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postAddQueue"/>',
                data: data
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showQueue($scope);
            });
        };

        $scope.removeQueue = function(ticketNo) {
            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postRemoveQueue"/>',
                data: { equipmentId: findEquipment(), ticketNo: ticketNo }
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showQueue($scope);
            });
        };

        $scope.showQueue = function(id) {
            $scope.equipmentId = id;
            showQueue($scope);
        };

        function findEquipment() {
            return $scope.equipmentId;
        }

        function showQueue(scope) {
            var data = { id: findEquipment() };

            var request = $.ajax({
                type: "get",
                url: '<c:url value="/showQueue"/>',
                data: data
            });

            request.done(function (data, textStatus, jqXHR) {
                scope.$apply(function(){
                    scope.queue = data;
                });
            });
        }
    });
</script>