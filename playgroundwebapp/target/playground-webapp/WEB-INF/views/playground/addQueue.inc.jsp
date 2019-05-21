<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/response.inc.jsp" />

<div class="form-group" ng-init="showEquipmentList()">
    <label for="equipment" class="control-label">Equipment list:</label>
    <div class="btn-group" role="group" id="equipment" aria-label="...">
        <button type="button" ng-repeat="item in equipmentList" ng-click="showQueue(item.id)" class="btn btn-default">
            {{item.name}}
        </button>
    </div>
</div>

<div class="form-group" ng-init="showKidList()">
    <label for="kid" class="control-label">Kid list:</label>
    <select class="form-control" id="kid">
        <option ng-repeat="item in kidList" value="{{item.ticketNo}}">{{item.name}}</option>
    </select>
</div>

<button type="button" class="btn btn-default" ng-click="addQueue()">Add Queue</button>

<hr/>

<p>
    <strong>Queue Length Is: {{queue.queueLength}}</strong>
</p>

<hr/>

<div class="row" ng-if="queue.vipQueue">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Ticket No</th>
            <th>Name</th>
            <th>Age</th>
            <th>Is VIP</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in queue.vipQueue">
            <td>{{item.ticketNo}}</td>
            <td>{{item.name}}</td>
            <td>{{item.age}}</td>
            <td>{{item.vip}}</td>
            <td><button type="button" class="btn btn-default" ng-click="removeQueue(item.ticketNo)">Remove Queue</button></td>
        </tr>
        </tbody>
    </table>
</div>

<hr/>

<div class="row" ng-if="queue.normalQueue">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Ticket No</th>
            <th>Name</th>
            <th>Age</th>
            <th>Is VIP</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in queue.normalQueue">
            <td>{{item.ticketNo}}</td>
            <td>{{item.name}}</td>
            <td>{{item.age}}</td>
            <td>{{item.vip}}</td>
            <td><button type="button" class="btn btn-default" ng-click="removeQueue(item.ticketNo)">Remove Queue</button></td>
        </tr>
        </tbody>
    </table>
</div>