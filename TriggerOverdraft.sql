CREATE DEFINER=`root`@`localhost` TRIGGER `accounts_AFTER_UPDATE` AFTER UPDATE ON `accounts` FOR EACH ROW BEGIN
IF NEW.ballance <= 0 THEN 
INSERT INTO overdraft(overdraft_id, amount, date_time, account_id)
VALUES (DEFAULT, NEW.ballance, NOW(), OLD.account_id);
END IF;
END