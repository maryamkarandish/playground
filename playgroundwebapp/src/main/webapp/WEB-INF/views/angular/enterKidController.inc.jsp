<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    app.controller('enterKidController', function($scope){
        $scope.showKidList = showKidList($scope);

        $scope.enterKid = function() {
            var request = $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                url: '<c:url value="/postEnterKid"/>',
                data: JSON.stringify($scope.data)
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showKidList($scope);
            });
        };

        $scope.exitKid = function(ticketNo) {
            var data ={ ticketNo: ticketNo };

            var request = $.ajax({
                type: "post",
                url: '<c:url value="/postExitKid"/>',
                data: data
            });

            request.done(function (data, textStatus, jqXHR) {
                $scope.$apply(function(){
                    $scope.response = data;
                });

                showKidList($scope);
            });
        };
    });
</script>