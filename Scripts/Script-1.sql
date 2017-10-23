show databases;

use product_project;

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

-- code를 삭제했을때 record와 sale도 함께 삭제
delimiter $$
create trigger tri_code_delete_record_sale
after delete on code
for each row begin
	delete from record
	where record.pdno = old.codeid;
	
	delete from sale
	where sale.salecd = old.codeid;
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

-- record가 삭제 되었을때 sale의 데이터도 함께 삭제
delimiter $$
create trigger tri_record_delete_sale
after delete on record
for each row begin
	delete from sale
	where sale.salecd = old.pdno;
end 
delimiter ;

-- 데이터 베이스에 입력
insert into record values("A001","아메리카노",4500,150,10),
						("A002","카푸치노",3800,140,15),
						("B001","딸기쉐이크",5200,250,12),
						("B002","후르츠와인",4300,110,11);

-- rank(판매순위)
select (select count(*)+1 from sale where saleprice > s1.saleprice) rank, 
 record.pdno pdno, record.pdname pdname, record.price price, record.amount, s1.supplyprice,  s1.surtax,  s1.saleprice, record.margin,  s1.mgrate from sale as s1
 inner join record on s1.salecd = record.pdno order by rank; 

 -- rank(마진율)
 select (select count(*)+1 from sale where mgrate > s1.mgrate) rank, 
 record.pdno pdno, record.pdname pdname, record.price price, record.amount, s1.supplyprice,  s1.surtax,  s1.saleprice, record.margin, s1.mgrate from sale as s1
 inner join record on s1.salecd = record.pdno order by rank; 
 
 
