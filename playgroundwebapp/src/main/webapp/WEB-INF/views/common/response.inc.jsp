<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div ng-if="response.code == 0" class="alert alert-success">
        <strong>{{response.message}}</strong>
    </div>
    <div ng-if="response.code == 1" class="alert alert-danger">
        <strong>{{response.message}}</strong>
    </div>
</div>