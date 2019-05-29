-- Database: `tra`
--

-- --------------------------------------------------------

--
-- Table structure for table `concept`
--

CREATE TABLE IF NOT EXISTS `concept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `explanation` varchar(500) DEFAULT NULL,  
  `instruction` varchar(200) NOT NULL,
  `unnamed` tinyint(1) NOT NULL,
  `weight_perc` decimal(5,2) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `domain`
--

CREATE TABLE IF NOT EXISTS `domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `instruction` varchar(200) DEFAULT NULL,
  `weight_perc` decimal(5,2) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `domain_concept`
--

CREATE TABLE IF NOT EXISTS `domain_concept` (
  `domain_id` int(11) NOT NULL,
  `concept_id` int(11) NOT NULL,
  CONSTRAINT `fk_domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`),
  CONSTRAINT `fk_concept_id` FOREIGN KEY (`concept_id`) REFERENCES `concept` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question_type`
--

CREATE TABLE IF NOT EXISTS `question_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `question_type_id` int(11) NOT NULL,
  `multi_answer` tinyint(1) NOT NULL DEFAULT '0',
  `explanation` varchar(500) DEFAULT NULL,
  `instruction` varchar(200) DEFAULT NULL,
  `text` varchar(200) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_q_name` (`name`),
  CONSTRAINT `fk_question_type_id` FOREIGN KEY (`question_type_id`) REFERENCES `question_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `concept_question`
--

CREATE TABLE IF NOT EXISTS `concept_question` (
  `concept_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,  
  CONSTRAINT `fk_cq_concept_id` FOREIGN KEY (`concept_id`) REFERENCES `concept` (`id`),
  CONSTRAINT `fk_cq_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  UNIQUE KEY `un_cq_concept_question` (`concept_id`,`question_id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `traoption`
--

CREATE TABLE IF NOT EXISTS `traoption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `point` int(11) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `concept_traoption`
--

CREATE TABLE IF NOT EXISTS `concept_traoption` (
  `concept_id` int(11) NOT NULL,
  `traoption_id` int(11) NOT NULL,
  CONSTRAINT `fk_ct_concept_id` FOREIGN KEY (`concept_id`) REFERENCES `concept` (`id`),
  CONSTRAINT `fk_ct_traoption_id` FOREIGN KEY (`traoption_id`) REFERENCES `traoption` (`id`),
  UNIQUE KEY `un_ct_concept_traoption` (`concept_id`,`traoption_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question_traoption`
--

CREATE TABLE IF NOT EXISTS `question_traoption` (
  `question_id` int(11) NOT NULL,
  `traoption_id` int(11) NOT NULL,
  CONSTRAINT `fk_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `fk_traoption_id` FOREIGN KEY (`traoption_id`) REFERENCES `traoption` (`id`),
  UNIQUE KEY `un_qt_question_traoption` (`question_id`,`traoption_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasession`
--

CREATE TABLE IF NOT EXISTS `trasession` (
  `session_id` varchar(100) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `completed` tinyint(1) NOT NULL,
  `selected_for_feedback` tinyint(1) NOT NULL,
  `score` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasession_answer`
--

CREATE TABLE IF NOT EXISTS `trasess_quest_traop` (
  `session_id` varchar(100) NOT NULL,
  `question_id` int(11) NOT NULL,
  `traoption_id` int(11) NOT NULL,
  CONSTRAINT `fk_tqt_session_id` FOREIGN KEY (`session_id`) REFERENCES `trasession` (`session_id`),
  CONSTRAINT `fk_tqt_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `fk_tqt_traoption_id` FOREIGN KEY (`traoption_id`) REFERENCES `traoption` (`id`),
  UNIQUE KEY `un_tqt_session_traoption` (`session_id`,`question_id`,`traoption_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

