$("button.createProduct")
    .click(
        function() {

            let name = $("form.createProduct input.productName").val();
            let description = $("form.createProduct input.productDescription").val();
            let price = $("form.createProduct input.productPrice").val();

            let product = {
                name : name,
                description : description,
                price : price
            };
//validation
            $.post("product", product,
                function(data) {
                    if (data == 'Success') {
                        alert('Success');
                    }
                });
        });
//buy button functionality
$("button.buy-product").click(function() {
    let productId = jQuery(this).attr("product-id");


    $.post("bucket", {'productId':productId},
        function(data) {
            if (data == 'Success') {
                $("[data-dismiss=modal]").trigger({ type: "click" });
                alert('Success');
            }
        });
});

