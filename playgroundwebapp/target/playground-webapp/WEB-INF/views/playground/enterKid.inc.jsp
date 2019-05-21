<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/response.inc.jsp" />

<div class="row" ng-init="showKidList()">
    <div class="form-group">
        <label class="control-label">Ticket No</label>
        <input type="text" class="form-control" ng-model="data.ticketNo">
    </div>

    <div class="form-group">
        <label class="control-label">Name</label>
        <input type="text" class="form-control" ng-model="data.name">
    </div>

    <div class="form-group">
        <label class="control-label">Age</label>
        <input type="text" class="form-control" ng-model="data.age">
    </div>

    <div class="form-group">
        <div class="checkbox">
            <label><input type="checkbox" ng-model="data.isVip">Is VIP</label>
        </div>
    </div>

    <button type="button" class="btn btn-default" ng-click="enterKid()">Add</button>
</div>

<div class="row">
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
        <tr ng-repeat="item in kidList">
            <td>{{item.ticketNo}}</td>
            <td>{{item.name}}</td>
            <td>{{item.age}}</td>
            <td>{{item.vip}}</td>
            <td><button type="button" class="btn btn-default" ng-click="exitKid(item.ticketNo)">Exit Kid</button></td>
        </tr>
        </tbody>
    </table>
</div>