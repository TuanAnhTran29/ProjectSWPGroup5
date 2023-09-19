use ProjectSWP;


create table Role(
	role_id int not null identity(1,1),
	role_name varchar(25)

	primary key (role_id)
);

create table Account(
	account_id int not null identity(1,1),
	username varchar(50),
	password varchar(125),
	status bit

	primary key (account_id)
);

create table Users (
	user_id int not null identity(1,1),
	full_name varchar(50),
	address varchar(125),
	date_of_birth date,
	phone varchar(20),
	gmail varchar(50),
	gender bit,
	avartar_link varchar(225),
	account_id int,
	role_id int

	primary key(user_id)
	foreign key(account_id) references Account(account_id),
	foreign key(role_id) references Role(role_id)
)

create table Customer(
	customer_id int not null identity(1,1),
	user_id int not null,
	region varchar(100),
	country varchar(100),
	balance float

	primary key(customer_id)
	foreign key(user_id) references Users(user_id)
);

create table EmployeeSalary(
	id int not null identity(1,1),
	user_id int not null,
	salary float

	primary key(id),
	foreign key(user_id) references Users(user_id)
);

create table Provider(
	provider_id int not null identity(1,1),
	user_id int not null,
	company_name varchar(100)

	primary key(provider_id),
	foreign key(user_id) references Users(user_id)
);

create table StorageStaff(
	storage_staff_id int not null identity(1,1),
	user_id int not null,
	storage_address varchar(50)

	primary key(storage_staff_id),
	foreign key(user_id) references Users(user_id)
);

create table Category(
	category_id int not null identity(1,1),
	category_name varchar(50)

	primary key(category_id)
);

create table Discount(
	discount_id int not null identity(1,1),
	discount_value float,
	start_date date,
	end_date date,
	limit int,
	active bit

	primary key(discount_id)
);

create table Product(
	product_id int not null identity(1,1),
	product_name varchar(100),
	expiry date,
	mani_date date,
	discount_id int,
	product_image varchar(225),
	price float,
	quantity int,
	active bit,
	provider_id int,
	category_id int
	
	primary key(product_id),
	foreign key(category_id) references Category(category_id),
	foreign key(provider_id) references Provider(provider_id),
	foreign key(discount_id) references Discount(discount_id)
);

create table ManagerOrder(
	manager_order_id int not null identity(1,1),
	manager_id int not null,
	order_date date,
	require_date date,
	ship_date date,
	ship_address varchar(100),
	contract_id int

	primary key(manager_order_id),
	foreign key(manager_id) references Users(user_id)
);

create table ManagerOrderDetail(
	detail_id int not null identity(1,1),
	product_id int not null,
	manager_order_id int not null,
	price float,
	quantity int

	primary key(detail_id),
	foreign key(product_id) references Product(product_id),
	foreign key(manager_order_id) references ManagerOrder(manager_order_id),
);

alter table Users add salary float;

create table CustomerOrder(
	order_id int not null identity(1,1),
	customer_id int not null,
	seller_id int not null,
	ship_date date,
	require_date date,
	order_date date,
	ship_address varchar(100),
	status bit

	primary key(order_id),
	foreign key(customer_id) references Customer(customer_id),
	foreign key(seller_id) references Users(user_id)
);

create table OrderDetail(
	id int not null identity(1,1),
	order_id int not null,
	product_id int not null,
	voucher_id int not null,
	price float,
	quantity int

	primary key(id),
	foreign key(order_id) references CustomerOrder(order_id),
	foreign key(product_id) references Product(product_id),
	foreign key(voucher_id) references Discount(discount_id)
);

create table Cart(
	cart_id int not null identity(1,1),
	customer_id int not null

	primary key(cart_id),
	foreign key(customer_id) references Customer(customer_id)
);

create table CartItem(
	id int not null identity(1,1),
	cart_id int not null,
	product_id int not null,
	quantity int

	primary key(id),
	foreign key (cart_id) references Cart(cart_id),
	foreign key(product_id) references Product(product_id)
);
