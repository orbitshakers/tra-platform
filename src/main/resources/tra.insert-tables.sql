--
-- Database: `tra`
--

--
-- Dumping data for table `concept`
--

INSERT INTO `concept` (`id`, `name`, `explanation`, `instruction`, `unnamed`, `weight_perc`, `sort_order`) VALUES
(1, 'Need for Telehealth', 'Consider your practice’s needs with respect to telehealth.', 'Please check one box in each row', 0, '10.00', 1),
(2, 'Organizational Leadership Buy-In', 'Consider whether your practice has support and direction from leadership.', 'Please check one box in each row', 0, '10.00', 2),
(3, '3-unnamed', 'Consider the financial implications of telehealth, including costs and reimbursement, for your practice.', 'Please check one box in each row', 1, '15.00', 1),
(4, 'Telehealth Roles', 'Consider the roles and responsibilities needed for telehealth.', 'Please check one box in each row', 0, '5.00', 1),
(5, 'Scheduling and Workflows', 'Consider how your practice will schedule telehealth visits and what the associated workflow will be for the visits.', 'Please check one box in each row', 0, '10.00', 2),
(6, 'Operational Requirements', 'Consider the operational requirements for telehealth for your practice.', 'Please check one box in each row', 0, '5.00', 3),
(7, 'Assessment Approach', 'Consider how your practice will monitor and assess implementation/outcomes.', 'Please check one box in each row', 0, '5.00', 4),
(8, 'Technology', 'Consider the technical infrastructure needed for telehealth in your practice.', 'Please check one box in each row', 0, '10.00', 5),
(9, 'Physical Space', 'Consider what facilities are needed for telehealth in your practice.', 'Please check one box in each row', 0, '5.00', 6),
(10, 'Education and Awareness', 'Consider how to increase awareness and engagement among staff.', 'Please check one box in each row', 0, '7.50', 1),
(11, 'Innovators/Champions', 'Consider who at your practice will support telehealth.', 'Please check one box in each row', 0, '7.50', 2),
(12, 'Patient Engagement', 'Consider how your practice will engage patients in telehealth services.', 'Please check one box in each row', 0, '5.00', 1),
(13, 'Health Literacy', 'What is your patient population’s capacity to obtain, process and understand basic health information needed to make appropriate health decisions?', 'Please check one box in each row', 0, '5.00', 2);

--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`id`, `name`, `instruction`, `weight_perc`, `sort_order`) VALUES
(1, 'Core Readiness', NULL, '20.00', 1),
(2, 'Financial Considerations', '', '15.00', 2),
(3, 'Operations', NULL, '40.00', 3),
(4, 'Staff Engagement', NULL, '15.00', 4),
(5, 'Patient Readiness', NULL, '10.00', 5);

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `name`, `title`, `question_type_id`, `multi_answer`, `explanation`, `instruction`, `text`, `sort_order`) VALUES
(1, 'Usecase', 'How Does/Will Your Practice Use TeleHealth?', 1, 1, 'Small physician practices can use telehealth in a variety of ways. For example, primary care physicians may use telehealth to provide their patients with access to off-site specialists. Providers may use telehealth to offer counseling or follow-up services to patients located in their home or office. <br/> As you complete this tool, please think about how your practice uses or is considering telehealth services.', 'Select all that apply.', 'Where will <b>patients</b> be located during telehealth visits?', 1);

--
-- Dumping data for table `question_traoption`
--

INSERT INTO `question_traoption` (`question_id`, `traoption_id`) VALUES
(1, 1),
(1, 2),
(1, 3);

--
-- Dumping data for table `question_type`
--

INSERT INTO `question_type` (`id`, `name`) VALUES
(3, 'CONCEPT'),
(2, 'DOMAIN'),
(1, 'STANDALONE');

--
-- Dumping data for table `traoption`
--

INSERT INTO `traoption` (`id`, `name`, `point`, `sort_order`) VALUES
(1, 'At one of our practice locations', 0, 1),
(2, 'Off-site: At another clinical location (clinic, practice, hospital)', 0, 2),
(3, 'Off-site: Patient’s home or work', 0, 3);
