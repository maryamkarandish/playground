<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row" ng-init="getPercentageOfUsageReport()">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Equipment ID</th>
            <th>Equipment Name</th>
            <th>Usage</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in response.percentageOfUsageReports">
            <td>{{item.equipmentId}}</td>
            <td>{{item.equipmentName}}</td>
            <td>{{item.usage}}</td>
        </tr>
        </tbody>
    </table>
</div>