const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.totalQuantity = 0;
    $scope.kmMa = "";
    $scope.totalPrice = 0;
    $scope.tongTienKhuyenMai = 0;
    $scope.tongTienTT = 0;
    $scope.tongTien = 0;
    $scope.KM = null;


    // Hàm để tải lại danh sách sản phẩm trong giỏ hàng
    function reloadCartItems() {
        $http.get('/rest/chitietgiohang')
            .then(function (response) {
                $scope.cartItems = response.data;
                calculateTotals();

            });
    }

    function calculateTotals() {
        $scope.totalQuantity = $scope.cartItems.length; // Tổng số lượng sản phẩm là số lượng chi tiết trong giỏ hàng

        for (let i = 0; i < $scope.cartItems.length; i++) {
            let item = $scope.cartItems[i];

            $scope.tongTien  += (item.chiTietSanPham.giaBan * item.soLuong);
            $scope.totalPrice =  $scope.tongTien;
        }
    }



    $scope.cart = {
        addToCart(productId) {
            $http.post('/rest/cart/add', { productId: productId })
                .then(function(response) {
                    if (response.data) {
                        alert("Thêm vào giỏ hàng thành công!");
                        reloadCartItems(); // Tải lại danh sách sau khi thêm thành công
                    } else {
                        alert("Thêm vào giỏ hàng không thành công!");
                    }
                })
                .catch(function(error) {
                    alert("Có lỗi xảy ra khi gọi API!");
                    console.error(error);
                });
        },

        remove(productId) {
            $http.post('/rest/cart/remove', { productId: productId })
                .then(function(response) {
                    alert("Xóa sản phẩm khỏi giỏ hàng thành công!");
                    reloadCartItems(); // Tải lại danh sách sau khi xóa thành công
                })
                .catch(function(error) {
                    alert("Có lỗi xảy ra khi gọi API!");
                    console.error(error);
                });
        },
        update(productId, quantity) {
            $http.post('/rest/cart/update', { productId: productId, quantity: quantity })
                .then(function(response) {
                    if (response.data) {
                        alert("Cập nhật giỏ hàng thành công!");
                        reloadCartItems(); // Tải lại danh sách sau khi cập nhật thành công
                    } else {
                        alert("Cập nhật giỏ hàng không thành công!");
                    }
                })
                .catch(function(error) {
                    alert("Có lỗi xảy ra khi gọi API!");
                    console.error(error);
                });
        },
        clear() {
            $http.post('/rest/cart/clear')
                .then(function(response) {
                    alert("Xóa tất cả sản phẩm khỏi giỏ hàng thành công!");
                    reloadCartItems(); // Tải lại danh sách sau khi xóa thành công
                })
                .catch(function(error) {
                    alert("Có lỗi xảy ra khi gọi API!");
                    console.error(error);
                });
        },

        addKM() { // Loại bỏ tham số kmId, vì giờ chúng ta đã có $scope.kmMa
            $http.post('/rest/order/addKM', { kmMa: $scope.kmMa }) // Sử dụng $scope.kmMa
                .then(function(response) {
                    alert("Thêm Khuyến mãi thành công!");
                    console.log(response.data)
                    $scope.totalPrice -= response.data.giaTri;
                    $scope.KM = response.data;
                    // reloadCartItems();
                })
                .catch(function(error) {
                    alert("Có lỗi xảy ra khi gọi API!");
                    console.error(error);
                });
        }
    }
    // ($scope.tongTien - $scope.KM.giaTri)
    reloadCartItems();
    $scope.donHang = {
        ngayTao: new Date(),
        tongTienTT: 0,
        tongTienKhuyenMai: 0,
        tongTien: $scope.tongTien,
        diaChi: "",
        trangThai: 2,
        get chiTietDonHangs(){
            return $scope.cartItems.map(item => {
                return {
                    gia: item.chiTietSanPham.giaBan,
                    soLuong: item.soLuong,
                    chiTietSanPham:{id: item.chiTietSanPham.id}

                }
            });
        },
        purchase(){
            var order = angular.copy(this);
            console.log(order)

            $http.post("/rest/order/add",order).then(resp => {
                alert("Dat hang thanh cong");
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Dat hang loi")
                console.log(error)
            })
        }
    }

});