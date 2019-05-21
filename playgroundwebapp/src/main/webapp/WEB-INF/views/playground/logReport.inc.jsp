<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row" ng-init="getPercentageOfUsageReport()">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Equipment ID</th>
            <th>Equipment Name</th>
            <th>Kid Name</th>
            <th>Added To Queue</th>
            <th>Started Date Time</th>
            <th>End Date Time</th>
            <th>During Time</th>
            <th>Ticket No</th>
            <th>Age</th>
            <th>Maximum Capacity</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in response">
            <td>{{item.equipmentId}}</td>
            <td>{{item.equipmentName}}</td>
            <td>{{item.name}}</td>
            <td>{{item.addedToQueue}}</td>
            <td>{{item.startDate}}</td>
            <td>{{item.endDate}}</td>
            <td>{{item.duringTime}}</td>
            <td>{{item.ticketNo}}</td>
            <td>{{item.age}}</td>
            <td>{{item.maximumEquipmentCapacity}}</td>
        </tr>
        </tbody>
    </table>
</div>