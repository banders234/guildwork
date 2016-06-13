/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
$('#product-create-submit').on('click', function(e) {
        
        e.preventDefault();
        
        var productData = JSON.stringify({
            type: $('#type-input').val(),
            materialCostPerSF: $('#material-cost-input').val(),
            laborCostPerSF: $('#labor-cost-input').val()
            
        });
        
        $.ajax({
            
            url: contextRoot + "/admin/product",
            type: "POST",
            data: productData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                alert("success");
                
                var tableRow = buildProductRow(data);
                
                $('#product-table').append($(tableRow));
            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                $('#add-product-validation-errors').append(validationError.fieldName + ": " + validationError.message).append("<br/>");
            });
            
            }
        });
        
        //alert("alert after ajax");
    });
    
    $('#editProductModal').on('show.bs.modal', function(e) {
        var link = $(e.relatedTarget);
        
        var productId = link.data('product-type');
        
        $.ajax({ 
        
            url: contextRoot + "/admin/product/" + productId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#edit-product-type').val(data.type);
                $('#edit-product-material-cost').val(data.materialCostPerSF);
                $('#edit-product-labor-cost').val(data.laborCostPerSF);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    
    $('#edit-product-button').on('click', function(e) {
        
        e.preventDefault();
        
        var productData = JSON.stringify({
            state: $('#edit-product-type').val(),
            materialCostPerSF: $('#edit-product-material-cost').val(),
            laborCostPerSF: $('#edit-product-labor-cost').val()
        });
        
        $.ajax({
            
            url: contextRoot + "/admin/product",
            type: "PUT",
            data: productData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                
                $('#editProductModal').modal('hide');
                
                var tableRow = buildProductRow(data);
                
                $('#product-row-' + data.state).replaceWith( $(tableRow) );
            },
            error: function(data, status) {
               alert("error");
            }
        });
        
        //alert("alert after ajax");
        
    });
    
    $(document).on('click', '.delete-link', function(e) {
        e.preventDefault();
        
        var productId = $(e.target).data('product-state');
        
        $.ajax({
            type: "DELETE",
            url: contextRoot + "/admin/product/" + productId,
            success: function(data, status) {
                $('#product-row-' + productId).remove();
            },
            error: function(data, status) {
                
            }
        });
    });
    function buildProductRow(data) {
                return "<tr id='product-row-" + data.type + "'>  \n\
                <td>" + data.type + "</td>    \n\
                <td>" + data.materialCostPerSF + "</td>    \n\
                <td>" + data.laborCostPerSF + "</td>    \n\
                <td> <a data-product-state='" + data.state +"' data-toggle='modal' data-target='#editProductModal'>Edit</a>  </td>   \n\
                <td> <a data-product-state='" + data.state +"' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";
    }
});    
