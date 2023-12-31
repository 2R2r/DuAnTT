USE [DuAnTT]
GO
/****** Object:  Table [dbo].[BaiViet]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaiViet](
	[Id] [uniqueidentifier] NOT NULL,
	[TieuDe] [nvarchar](50) NULL,
	[NoiDung] [nvarchar](max) NULL,
	[HinhAnh] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[IdNguoiDung] [uniqueidentifier] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_BaiViet] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDonHang]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonHang](
	[Id] [uniqueidentifier] NOT NULL,
	[Gia] [decimal](10, 2) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[IdDonHang] [uniqueidentifier] NULL,
	[IdChiTietSanPham] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietGioHang]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietGioHang](
	[Id] [uniqueidentifier] NOT NULL,
	[IdGioHang] [uniqueidentifier] NULL,
	[IdChiTietSanPham] [uniqueidentifier] NULL,
	[SoLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[GiaNhap] [decimal](10, 2) NULL,
	[GiaBan] [decimal](10, 2) NULL,
	[SoLuong] [int] NULL,
	[HinhAnh] [nvarchar](max) NULL,
	[TrangThai] [bit] NULL,
	[IdSanPham] [uniqueidentifier] NULL,
	[IdKichThuoc] [uniqueidentifier] NULL,
	[IdMauSac] [uniqueidentifier] NULL,
 CONSTRAINT [PK__Product__3214EC07E36F0A41] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[Id] [uniqueidentifier] NOT NULL,
	[NgayTao] [date] NOT NULL,
	[TongTienTT] [decimal](18, 0) NULL,
	[TongTienKhuyenMai] [decimal](18, 0) NULL,
	[TongTien] [decimal](10, 2) NOT NULL,
	[SDT] [nchar](20) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[IdNguoiDung] [uniqueidentifier] NULL,
	[IdKhuyenMai] [uniqueidentifier] NULL,
	[IdPhuongThucThanhToan] [uniqueidentifier] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK__DonHang__3214EC07F18BAA07] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[Id] [uniqueidentifier] NOT NULL,
	[IdNguoiDung] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [nvarchar](50) NULL,
	[Ten] [nvarchar](max) NULL,
	[GiaTri] [decimal](10, 2) NOT NULL,
	[BatDau] [date] NULL,
	[KetThuc] [date] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK__Voucher__3214EC07E0FD4E73] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](255) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK__Size__3214EC07CBD37A7B] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](255) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK__Color__3214EC07C5B7030A] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[Id] [uniqueidentifier] NOT NULL,
	[TaiKhoan] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[SDT] [nvarchar](15) NULL,
	[Email] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[TrangThai] [int] NULL,
	[IdVaiTro] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_NSX] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuongThucThanhToan]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuongThucThanhToan](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[IdTheLoai] [uniqueidentifier] NULL,
	[MoTa] [nvarchar](max) NULL,
	[IdNSX] [uniqueidentifier] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoai]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoai](
	[Id] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK__Category__3214EC07AF273DAA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VaiTro]    Script Date: 11/15/2023 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VaiTro](
	[Id] [uniqueidentifier] NOT NULL,
	[TenVaiTro] [nvarchar](100) NOT NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietDonHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietGioHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  CONSTRAINT [DF__Product__Id__3F466844]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[DonHang] ADD  CONSTRAINT [DF__DonHang__Id__5165187F]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[GioHang] ADD  CONSTRAINT [DF__Cart__AccountId__4F7CD00D]  DEFAULT (newid()) FOR [IdNguoiDung]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF__Voucher__Id__5BE2A6F2]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KichThuoc] ADD  CONSTRAINT [DF__Size__Id__3C69FB99]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[MauSac] ADD  CONSTRAINT [DF__Color__Id__398D8EEE]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NguoiDung] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NSX] ADD  CONSTRAINT [DF_NSX_Id]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_Id]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[TheLoai] ADD  CONSTRAINT [DF__Category__Id__36B12243]  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[VaiTro] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[BaiViet]  WITH CHECK ADD  CONSTRAINT [FK_BaiViet_NguoiDung] FOREIGN KEY([IdNguoiDung])
REFERENCES [dbo].[NguoiDung] ([Id])
GO
ALTER TABLE [dbo].[BaiViet] CHECK CONSTRAINT [FK_BaiViet_NguoiDung]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_ChiTietSanPham] FOREIGN KEY([IdChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([Id])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_ChiTietSanPham]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_DonHang] FOREIGN KEY([IdDonHang])
REFERENCES [dbo].[DonHang] ([Id])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_DonHang]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietGioHang_ChiTietSanPham] FOREIGN KEY([IdChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([Id])
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [FK_ChiTietGioHang_ChiTietSanPham]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietGioHang_GioHang] FOREIGN KEY([IdGioHang])
REFERENCES [dbo].[GioHang] ([Id])
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [FK_ChiTietGioHang_GioHang]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_KichThuoc] FOREIGN KEY([IdKichThuoc])
REFERENCES [dbo].[KichThuoc] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_KichThuoc]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_MauSac] FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_MauSac]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham] FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_KhuyenMai] FOREIGN KEY([IdKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_KhuyenMai]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_NguoiDung] FOREIGN KEY([IdNguoiDung])
REFERENCES [dbo].[NguoiDung] ([Id])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_NguoiDung]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_PhuongThucThanhToan] FOREIGN KEY([IdPhuongThucThanhToan])
REFERENCES [dbo].[PhuongThucThanhToan] ([Id])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_PhuongThucThanhToan]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_NguoiDung] FOREIGN KEY([IdNguoiDung])
REFERENCES [dbo].[NguoiDung] ([Id])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_NguoiDung]
GO
ALTER TABLE [dbo].[NguoiDung]  WITH CHECK ADD  CONSTRAINT [FK_NguoiDung_VaiTro] FOREIGN KEY([IdVaiTro])
REFERENCES [dbo].[VaiTro] ([Id])
GO
ALTER TABLE [dbo].[NguoiDung] CHECK CONSTRAINT [FK_NguoiDung_VaiTro]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NSX] FOREIGN KEY([IdNSX])
REFERENCES [dbo].[NSX] ([Id])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NSX]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_TheLoai1] FOREIGN KEY([IdTheLoai])
REFERENCES [dbo].[TheLoai] ([Id])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_TheLoai1]
GO
