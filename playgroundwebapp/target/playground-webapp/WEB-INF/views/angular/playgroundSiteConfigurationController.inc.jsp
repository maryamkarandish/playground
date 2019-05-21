<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    app.controller('playgroundSiteConfigurationController', function($scope){
        $scope.showEquipmentList = showEquipmentList($scope);

        $scope.showDefaultEquipmentList = function() {
            var request = $.ajax({
                type: "get",
                contentType: "application/json; charset=utf-8",
                url: '<c:url value="/showDefaultEquipmentList"/>'
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.defaultEquipmentList = data;
                });
            });
        };

        $scope.addEquipment = function() {
            var data ={ type: $("#equipment").val() };
            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postAddEquipment"/>',
                data: data
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showEquipmentList($scope);
            });
        };

        $scope.removeEquipment = function(id) {
            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postRemoveEquipment"/>',
                data: { id: id}
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showEquipmentList($scope);
            });
        };
    });
</script>