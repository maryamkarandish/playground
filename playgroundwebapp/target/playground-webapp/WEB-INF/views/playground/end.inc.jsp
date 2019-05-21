<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/response.inc.jsp" />

<div class="form-group" ng-init="showEquipmentList()">
    <label for="equipment" class="control-label">Equipment list:</label>
    <select class="form-control" id="equipment">
        <option ng-repeat="item in equipmentList" value="{{item.id}}">{{item.name}}</option>
    </select>
</div>

<button type="button" class="btn btn-default" ng-click="end()">End</button>