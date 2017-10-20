show databases;

show tables;


select * from code;
select * from sale;		  
select * from record;

-- 입력데이터에 입력을 하면 자동으로 판매기록 데이터에 저장 
delimiter $$
create trigger tri_record_after_insert_sale
after insert on record
for each row begin
	insert into sale(salecd, saleprice, surtax, supplyprice, mgrate) 
	values(new.pdno, new.price*new.amount, ceiling(saleprice/11), saleprice-surtax, round(supplyprice*(new.margin*0.01)));
end 
delimiter ;

-- 입력데이터를 업데이트 했을 때 판매 기록 데이터가 업데이트 되는 것.
delimiter $$
create trigger tri_record_update_sale
after update on record
for each row begin
	update sale
	set salecd = new.pdno, saleprice = new.price*new.amount, surtax = ceiling(saleprice/11), supplyprice=saleprice-surtax, mgrate=round(supplyprice*(new.margin*0.01))
	where sale.salecd=old.pdno;
end 
delimiter ;

-- code를 업데이트 했을때 record와 sale이 업데이트 
delimiter $$
create trigger tri_code_update_record_sale
after update on code
for each row begin
	update record
	set pdno = new.codeid,pdname=new.codename
	where record.pdno = old.codeid;
	
	update sale
	set salecd = new.codeid
	where sale.salecd = old.codeid;
	
end 
delimiter ;


drop trigger tri_code_update_record_sale;