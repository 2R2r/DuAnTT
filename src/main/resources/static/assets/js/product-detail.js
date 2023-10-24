// document.addEventListener('DOMContentLoaded', function () {
//     var colors = document.querySelectorAll('.color-label');
//     var sizes = document.querySelectorAll('.size-label');
//
//     var colorsSelected = false;
//     var sizesSelected = false;
//
//     colors.forEach(function (color) {
//         color.addEventListener('click', function () {
//             if (this.classList.contains('selected-color')) {
//                 this.classList.remove('selected-color');
//                 colorsSelected = false;
//             } else {
//                 colors.forEach(function (color) {
//                     color.classList.remove('selected-color');
//                 });
//                 this.classList.add('selected-color');
//                 colorsSelected = true;
//             }
//             showImage();
//             checkAndSendData(); // Kiểm tra và gửi dữ liệu
//         });
//     });
//
//     sizes.forEach(function (size) {
//         size.addEventListener('click', function () {
//             if (this.classList.contains('selected-size')) {
//                 this.classList.remove('selected-size');
//                 sizesSelected = false;
//             } else {
//                 sizes.forEach(function (size) {
//                     size.classList.remove('selected-size');
//                 });
//                 this.classList.add('selected-size');
//                 sizesSelected = true;
//             }
//             showImage();
//             checkAndSendData(); // Kiểm tra và gửi dữ liệu
//         });
//     });
//
//     function checkAndSendData() {
//         if (colorsSelected && sizesSelected) {
//             sendSelectedData(); // Gọi khi cả hai đều được chọn
//         }
//     }
//
//     var xhr = new XMLHttpRequest();
//
//     function showImage() {
//         var selectedColor = document.querySelector('.selected-color');
//         var selectedSize = document.querySelector('.selected-size');
//         var productId = document.getElementById('product-id').textContent;
//         var colorId = selectedColor ? selectedColor.getAttribute('for').replace('mauSac_', '') : null;
//         var sizeId = selectedSize ? selectedSize.getAttribute('for').replace('kichThuoc_', '') : null;
//
//         xhr.open('POST', '/product/detailImage', true);
//         xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
//         xhr.onload = function () {
//             if (xhr.status >= 200 && xhr.status < 400) {
//                 document.getElementById('product-image').src = '/assets/images/' + JSON.parse(xhr.responseText).hinhAnh + '.jpg';
//             }
//         };
//         xhr.send('colorId=' + colorId + '&sizeId=' + sizeId + '&productId=' + productId);
//     }
//
//     function sendSelectedData() {
//         var cartButton = document.getElementById('cart-button');
//         var dataId = null;
//         var selectedColor = document.querySelector('.selected-color');
//         var selectedSize = document.querySelector('.selected-size');
//         var productId = document.getElementById('product-id').textContent;
//         var colorId = selectedColor ? selectedColor.getAttribute('for').replace('mauSac_', '') : null;
//         var sizeId = selectedSize ? selectedSize.getAttribute('for').replace('kichThuoc_', '') : null;
//
//         var xhr = new XMLHttpRequest();
//         xhr.open('POST', '/product/detail', true);
//         xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
//         xhr.onload = function () {
//             if (xhr.status >= 200 && xhr.status < 400) {
//                 var data = JSON.parse(xhr.responseText);
//                 updateProductDetails(data);
//
//                 cartButton.removeAttribute("disabled");
//                 dataId = data.id !== null ? data.id : null;
//
//                 // Cập nhật thuộc tính ng-click
//                 cartButton.setAttribute("ng-click", "cart.addToCart('" + dataId + "')");
//
//                 // Biên dịch lại nút "Cart"
//                 var $injector = angular.injector(['ng']);
//                 $injector.invoke(['$compile', function ($compile) {
//                     var $scope = angular.element(cartButton).scope();
//                     $compile(cartButton)($scope);
//                 }]);
//             } else if (xhr.status === 404 || JSON.parse(xhr.responseText).soLuong < 1) {
//                 showImage();
//                 cartButton.setAttribute("disabled", "true");
//                 cartButton.removeAttribute("ng-click");
//                 document.getElementById('product-soLuong').innerText = 'Số lượng: Hết hàng';
//             }
//
//             var element = document.getElementById('cart-button'); // Thay '#cart-button' bằng selector phù hợp
//             element.classList.remove('ng-scope');
//         };
//         xhr.send('colorId=' + colorId + '&sizeId=' + sizeId + '&productId=' + productId);
//
//     }
//
//     function updateProductDetails(data) {
//         var item = data;
//         document.getElementById('product-price').innerText = item.giaBan;
//         document.getElementById('product-soLuong').innerText = 'Số lượng: ' + item.soLuong;
//     }
// });