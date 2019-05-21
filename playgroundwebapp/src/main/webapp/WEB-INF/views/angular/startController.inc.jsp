<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    app.controller('startController', function($scope){
        $scope.showEquipmentList = showEquipmentList($scope);

        $scope.start = function(id) {
            var data = { id: id };

            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postStart"/>',
                data: data
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });
            });
        };

        $scope.end = function(id) {
            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postEnd"/>',
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