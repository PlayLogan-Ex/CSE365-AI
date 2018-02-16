CREATE TABLE question (
  questionID int(11) NOT NULL,
  questionText varchar(100) NOT NULL,
  tag varchar(20) NOT NULL,
  questionHolder varchar(50) NOT NULL,
  time date NOT NULL,
  totalLike int(11) NOT NULL,
  totalDislike int(11) NOT NULL,
  totalComment int(11) NOT NULL
);
$query = "CREATE TABLE question (
  questionID int(11) NOT NULL,
  questionText varchar(100) NOT NULL,
  tag varchar(20) NOT NULL,
  questionHolder varchar(50) NOT NULL,
  time date NOT NULL,
  totalLike int(11) NOT NULL,
  totalDislike int(11) NOT NULL,
  totalComment int(11) NOT NULL
);";

INSERT INTO question(questionText, tag) VALUES ('q1', 'qtag');
$sql  = 'INSERT INTO question(questionText, tag) VALUES (\'q1\', \'qtag\')';

UPDATE question SET questionID=112 WHERE questionID=11
$sql  = 'UPDATE question SET questionID=11 WHERE questionID=112';

DELETE FROM question WHERE questionID = 12
$sql  = 'DELETE FROM question WHERE questionID = 13';
