-- 생성된 테이블 확인
show tables;

-- 각 테이블 확인
desc code;
desc record;
desc sale;

-- 테이블 저장 데이터 확인
select * from code;
select * from record;
select * from sale;

-- trigger 판매액에 관해서 trigger 작성
delimiter $$
create trigger tri_record_insert_sale
after insert on record
for each row begin
	INSERT INTO sale(salecd,saleprice,surtax,supplyprice,mgrate) 
	value(NEW.pdno,NEW.price * new.amount,ceiling(saleprice / 11),saleprice - surtax,round(supplyprice*(new.margin*0.01)));
end;
delimiter ;

-- update trigger record를 수정하면 같이 수정
delimiter $$
create trigger tri_record_update_sale
after update 
on record
for each row begin
	update sale 
	set salecd = new.pdno
	where sale.salecd=old.pdno;
end 
delimiter ; 

insert into code values("B005","스무디");
insert into record values("B005","스무디",5200,250,12);

update record
set pdno="B006",pdname="야야"
where pdno="B005";


delete from code
where codeid="B006";

delete from record
where pdno="B005";

drop trigger tri_code_update_record;

delimiter $$
create trigger tri_record_update_sale
before update 
on record
for each row begin
	update sale
	set salecd=new.pdno
	where sale.salecd= old.pdno;
end 
delimiter ; 