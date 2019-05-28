-- Database: `tra`
--

-- --------------------------------------------------------

--
-- Table structure for table `concept`
--

CREATE TABLE IF NOT EXISTS `concept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `instruction` varchar(200) NOT NULL,
  `unnamed` tinyint(1) NOT NULL,
  `weight_perc` decimal(3,2) NOT NULL,
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
  `weight_perc` decimal(3,2) NOT NULL,
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
  `concept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `question_type` varchar(50) NOT NULL,
  `is_multi_answer` tinyint(1) NOT NULL DEFAULT '0',
  `explanation` varchar(200) DEFAULT NULL,
  `instruction` int(200) DEFAULT NULL,
  `text` int(100) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `traoption`
--

CREATE TABLE IF NOT EXISTS `traoption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `point` int(11) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `trasession`
--

CREATE TABLE IF NOT EXISTS `trasession` (
  `session_id` varchar(100) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `completed` tinyint(4) NOT NULL,
  `selected_for_feedback` tinyint(4) NOT NULL,
  `score` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasession_answer`
--

CREATE TABLE IF NOT EXISTS `trasession_answer` (
  `session_id` varchar(100) NOT NULL,
  `selected_traoption_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

