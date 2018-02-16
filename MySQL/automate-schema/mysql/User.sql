--
-- Table structure for table `user`
--

CREATE TABLE user (
  email varchar(50) NOT NULL,
  firstName varchar(20) NOT NULL,
  lastName varchar(20) NOT NULL,
  password varchar(40) NOT NULL,
  address varchar(50) NOT NULL,
  profession varchar(20) NOT NULL,
  contactNo int(11) NOT NULL,
  researchArea varchar(100) NOT NULL,
  hobby varchar(50) NOT NULL
);

--
-- Indexes for table `user`
--
ALTER TABLE user
  ADD PRIMARY KEY (email);
