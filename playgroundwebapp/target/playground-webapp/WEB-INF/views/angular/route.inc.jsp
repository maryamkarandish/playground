<script>
    app.config(function ($routeProvider) {
        $routeProvider
            .when('/playgroundSiteConfiguration', {
                templateUrl: 'playgroundSiteConfiguration',
                controller: 'playgroundSiteConfigurationController'
            })
            .when('/enterKid', {
                templateUrl: 'enterKid',
                controller: 'enterKidController'
            })
            .when('/addQueue', {
                templateUrl: 'addQueue',
                controller: 'addQueueController'
            })
            .when('/removeQueue', {
                templateUrl: 'removeQueue',
                controller: 'removeQueueController'
            })
            .when('/start', {
                templateUrl: 'start',
                controller: 'startController'
            })
            .when('/end', {
                templateUrl: 'end',
                controller: 'endController'
            })
            .when('/usageReport', {
                templateUrl: 'usageReport',
                controller: 'getPercentageOfUsageReportController'
            })
            .when('/logReport', {
                templateUrl: 'logReport',
                controller: 'fetchLogReportController'
            })
            .otherwise({
                redirectTo: '/',
                controller: 'playgroundSiteConfigurationController'
            });
    });
</script>