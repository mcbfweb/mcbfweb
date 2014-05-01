<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<sjm:head jqueryui="false" compressed="true" />
<script>
$.widget( "ui.tabs", $.ui.tabs, {

    _createWidget: function( options, element ) {
        var page, delayedCreate,
            that = this;

        if ( $.mobile.page ) {
            page = $( element )
                .parents( ":jqmData(role='page'),:mobile-page" )
                .first();

            if ( page.length > 0 && !page.hasClass( "ui-page-active" ) ) {
                delayedCreate = this._super;
                page.one( "pagebeforeshow", function() {
                    delayedCreate.call( that, options, element );
                });
            }
        } else {
            return this._super();
        }
    }
});
</script>


<script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script>
<link rel="stylesheet" href="css/themes/MobileAppTheme-Nicole.min.css" />
<link rel="stylesheet" href="css/themes/jquery.mobile.icons.min.css" />
<script src="js/mcbf-scripts.js" type="text/javascript"></script>
<script src="js/jquery.ui.map.full.min.js" type="text/javascript"></script>
<title>MCBF</title>

</head>

<body>