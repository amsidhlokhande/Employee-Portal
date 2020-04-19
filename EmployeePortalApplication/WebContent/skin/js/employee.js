/* Javascript file that is used by the Employee Catalog portlet */
$(document).ready(function() {
	var msg = $(message);
	if (msg != null && msg.trim().length() > 0) {
		alert(msg);
	}
});

function submittedAction(actionUrl)
{
	alert(actionUrl);
	
	$(employeeEnrollementForm).action(actionUrl);
	$(employeeEnrollementForm).submit();
}