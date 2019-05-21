<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/response.inc.jsp" />

<div class="form-group" ng-init="showDefaultEquipmentList()">
    <label for="equipment" class="control-label">Equipment list:</label>
    <select class="form-control" id="equipment">
        <option ng-repeat="item in defaultEquipmentList" value="{{item.type}}">{{item.name}}</option>
    </select>
</div>

<button type="button" class="btn btn-default" ng-click="addEquipment()">Add Equipment</button>

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
            <td><button type="button" class="btn btn-default" ng-click="removeEquipment(item.id)">Remove Equipment</button></td>
        </tr>
        </tbody>
    </table>
</div>