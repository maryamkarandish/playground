<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/response.inc.jsp" />

<div class="form-group" ng-init="showEquipmentList()">
    <label for="equipment" class="control-label">Equipment list:</label>
    <div class="btn-group" role="group" id="equipment" aria-label="...">
        <button type="button" ng-repeat="item in equipmentList" ng-click="start(item.id)" class="btn btn-default">
            {{item.name}}
        </button>
    </div>
</div>

<hr />

<div class="row">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Capacity</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in equipmentList">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
            <td>{{item.capacity}}</td>
            <td><button type="button" class="btn btn-default" ng-click="end(item.id)">End</button></td>
        </tr>
        </tbody>
    </table>
</div>