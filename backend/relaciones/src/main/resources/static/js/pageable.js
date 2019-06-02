$(document).ready(function() {
	var page = 1;
	$("#showMore").click(function(){
			//Hide button and show spinner
	        $(this).hide();
	        $('#loading').html('<img src="resources\static\images\spinner.gif" width="80px" height="80px"/>');		
	        //Data upload
			$.ajax({
				url: ('showMore/'+page),
				dataType: 'html',
				success: function(html) {
					$('#units').append(html);
					$(this).hide();
					page++;
				}
			});
			//Show button and hide spinner
			$(this).show();
			$('#loading').hide(); 
	 });
	
});