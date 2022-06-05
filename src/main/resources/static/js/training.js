$(document).ready(function() {
    $("#train_message").on("change keyup paste input", function () {
        let sourceMessage = $("#source_message").val();
        let textarea = $("#train_message");
        let inputMessage = textarea.val();

        if (sourceMessage === inputMessage) {
            textarea.removeClass("bg-danger").addClass("bg-success");
        } else {
            textarea.removeClass("bg-success").addClass("bg-danger");
        }
    });
});