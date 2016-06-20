/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('#create-submit').on('click', function(e) {
        
        e.preventDefault();
        
        var orderData = JSON.stringify({
            customerName: $('#customer-name-input').val(),
            date: $('#date-input').val(),
            area: $('#area-input').val(),
            state: $('#state-input').val(),
            productType: $('#product-type-input').val()
            
        });
        
        $.ajax({
            
            url: contextRoot + "/order",
            type: "POST",
            data: orderData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
                $('#add-contact-validation-errors').empty();
            },
            success: function(data, status) {
                $('#customer-name-input').val("");
                $('#date-input').val("");
                $('#area-input').val("");
                $('#state-input').val("");
                $('#product-type-input').val("");
                var tableRow = buildOrderRow(data);
                var valueExists = false;
                for (i = 0; i < document.getElementById("filter-date").length; ++i){
                    if (document.getElementById("filter-date").options[i].value == data.dateString){
                        valueExists = true;
                    }
                }
                if (valueExists !== true) {
                    $('#filter-date').append($('<option>', {
                        value: data.dateString,
                        text: data.dateString
                    }));
                }
                $('#order-table').append($(tableRow));
            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                $('#add-contact-validation-errors').append(validationError.fieldName + ": " + validationError.message).append("<br/>");
            });
            
            }
        });
        
        //alert("alert after ajax");
    });
    
    $('#showOrderModal').on('show.bs.modal', function(e) {
        var link = $(e.relatedTarget);
        
        var orderId = link.data('order-order-number');
        
        $.ajax({ 
        
            url: contextRoot + "/order/" + orderId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#order-date').text((data.dateString));
                $('#order-customer-name').text(data.customerName);
                $('#order-area').text((data.area).toFixed(2));
                $('#order-product-type').text(data.productType);
                $('#order-state').text(data.state);
                $('#order-tax-rate').text(data.taxRate);
                $('#order-material-cost-per-sf').text(data.materialCostPerSF);
                $('#order-labor-cost-per-sf').text(data.laborCostPerSF);
                $('#order-material-cost').text((data.materialCost).toFixed(2));
                $('#order-labor-cost').text((data.laborCost).toFixed(2));
                $('#order-tax').text((data.tax).toFixed(2));
                $('#order-total').text((data.total).toFixed(2));
            },
            error: function(data, status) {
                
            }
        
        });
    });
    $('#editOrderModal').on('show.bs.modal', function(e) {
        var link = $(e.relatedTarget);
        
        var orderId = link.data('order-order-number');
        
        $.ajax({ 
        
            url: contextRoot + "/order/" + orderId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                var d = new Date(data.date);
                var dateString = d.getFullYear() + "-" + ("0"+(d.getMonth()+1)).slice(-2) + "-" + ("0" + d.getDate()).slice(-2);
                $('#edit-order-customer-name').val(data.customerName);
                $('#edit-order-date').val(dateString);
                $('#edit-order-state').val(data.state);
                $('#edit-order-product-type').val(data.productType);
                $('#edit-order-area').val(data.area);
                $('#edit-order-number').val(data.orderNumber);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    
    $('#edit-order-button').on('click', function(e) {
        
        e.preventDefault();
        
        var orderData = JSON.stringify({
            date: $('#edit-order-date').val(),
            customerName: $('#edit-order-customer-name').val(),
            productType: $('#edit-order-product-type').val(),
            state: $('#edit-order-state').val(),
            area: $('#edit-order-area').val(),
            id: $('#edit-order-number').val()
        });
        
        $.ajax({
            
            url: contextRoot + "/order",
            type: "PUT",
            data: orderData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                
                $('#editOrderModal').modal('hide');
                
                var tableRow = buildOrderRow(data);
                
                $('#order-row-' + data.orderNumber).replaceWith( $(tableRow) );
            },
            error: function(data, status) {
               alert("error");
            }
        });
        
        //alert("alert after ajax");
        
    });
    
    $(document).on('click', '.delete-link', function(e) {
        e.preventDefault();
        
        var orderId = $(e.target).data('order-order-number');
        
        $.ajax({
            type: "DELETE",
            url: contextRoot + "/order/" + orderId,
            success: function(data, status) {
                $('#order-row-' + orderId).remove();
            },
            error: function(data, status) {
                
            }
        });
    });
    
    
    $(document).on('change', '#filter-date', function(e) {
        e.preventDefault();
        
        var filterDate = $('#filter-date').val();
        if (filterDate === "Show All" ) {
            $("#order-table tbody tr").each(function() {
            }).show();
        }
        else {
            console.log(filterDate);
            filterOrderRows(filterDate);
        }
    });
    $(document).on('click', '#show-all-order-table', function(e) {
        e.preventDefault();
        
        $("#order-table tbody tr").each(function() {
        }).show();
        
    });
    function filterOrderRows(filterDate){
        $("#order-table tbody tr").filter(function() {
            var orderDate = $(this).find('#order-date-cell').text();
            return orderDate !== filterDate;
        }).hide();
        $("#order-table tbody tr").filter(function() {
            var orderDate = $(this).find('#order-date-cell').text();
            return orderDate === filterDate;
        }).show();
    };
    
    function buildOrderRow(data) {
                return "<tr id='order-row-" + data.orderNumber + " order-date-" + data.dateString +"'>  \n\
                <td id='order-date-cell'>" + data.dateString + "</td>    \n\
                <td> <a data-order-order-number='" + data.orderNumber +"' data-toggle='modal' data-target='#showOrderModal'>" + data.customerName + "</a></td>  \n\
                <td> <a data-order-order-number='" + data.orderNumber +"' data-toggle='modal' data-target='#editOrderModal'>Edit</a>  </td>   \n\
                <td> <a data-order-order-number='" + data.orderNumber +"' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";
    }
    
    
});

