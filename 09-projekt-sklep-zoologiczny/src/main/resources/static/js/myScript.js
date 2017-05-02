$(document).ready(function () {
    $("#switch").on("click", function () {

        if ($(this).text() == "Add") {
            $(this).text("Choose");
            $("#Category2").attr('type', 'text');
            $("#Category").hide();
        } else {
            $(this).text("Add");
            $("#Category2").attr('type', 'hidden');
            $("#Category").show();
        }
        }
    );
    $("#productForm").submit(function () {
        if ($("#Category").is(":visible")) {
            $("#inputCategory").val($("#Category").val());
        } else {
            $("#inputCategory").val($("#Category2").val());
        }
    });

});