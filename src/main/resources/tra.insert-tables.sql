-- --------------------------------------------------------
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

-- --------------------------------------------------------
--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`id`, `name`, `instruction`, `weight_perc`, `sort_order`) VALUES
(1, 'Core Readiness', NULL, '20.00', 1),
(2, 'Financial Considerations', '', '15.00', 2),
(3, 'Operations', NULL, '40.00', 3),
(4, 'Staff Engagement', NULL, '15.00', 4),
(5, 'Patient Readiness', NULL, '10.00', 5);

-- --------------------------------------------------------
--
-- Dumping data for table `question_type`
--

INSERT INTO `question_type` (`id`, `name`) VALUES
(1, 'STANDALONE'),
(2, 'CONCEPT'),
(3, 'FEEDBACK');

-- --------------------------------------------------------
--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `name`, `title`, `question_type_id`, `multi_answer`, `explanation`, `instruction`, `text`, `sort_order`) VALUES
(1, 'Usecase', 'How Does/Will Your Practice Use TeleHealth?', 1, 1, 'Small physician practices can use telehealth in a variety of ways. For example, primary care physicians may use telehealth to provide their patients with access to off-site specialists. Providers may use telehealth to offer counseling or follow-up services to patients located in their home or office. <br/> As you complete this tool, please think about how your practice uses or is considering telehealth services.', 'Select all that apply.', 'Where will <b>patients</b> be located during telehealth visits?', 1),
(2, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice have difficulty getting the medical care they need because providers are too far away, patients lack transportation, or patients are unable to leave work or home?', 1),
(3, NULL, NULL, 2, 0, NULL, NULL, 'Has your organization identified specific types of patients or clinical needs that may benefit from using telehealth?', 2),
(4, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice ask for telehealth services or express interest in aspects of telehealth such as remote visits?', 3),
(5, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice use or express a need or desire for after-hours (evenings and weekends) medical care?', 4),
(6, NULL, NULL, 2, 0, NULL, NULL, 'Do providers affiliated with your practice routinely travel over 30 minutes from their primary location to provide services in other locations?', 5),
(7, NULL, NULL, 2, 0, NULL, NULL, 'Do the potential benefits of telehealth for your practice outweigh the potential challenges associated with telehealth?', 6),
(8, NULL, NULL, 2, 0, NULL, NULL, 'Is your practice’s leadership committed to telehealth development efforts?', 1),
(9, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified the vision, priorities, and goals for implementing telehealth?', 2),
(10, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice created a telehealth business plan?', 3),
(11, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice’s leadership had past successes with instituting programs that required complex change processes, such as quality improvement initiatives or electronic health record implementations?', 4),
(12, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how it will fund any capital costs (e.g., equipment, software, licensing) needed to start a telehealth program?', 1),
(13, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified what additional staffing costs, if any, are needed to implement and maintain a telehealth program?', 2),
(14, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice examined the telehealth services reimbursement policies for major insurers (Medicare/Medicaid, and private insurance)?', 3),
(15, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered whether it would be financially feasible to offer telehealth services that are reimbursed by some but not all insurers?', 4),
(16, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice gathered the necessary information to conduct a cost, benefit, and risk analysis of implementing and using telehealth?', 5);


-- --------------------------------------------------------
--
-- Dumping data for table `concept_question`
--

INSERT INTO `concept_question` (`concept_id`, `question_id`) VALUES
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11);

-- --------------------------------------------------------
--
-- Dumping data for table `domain_concept`
--

INSERT INTO `domain_concept` (`domain_id`, `concept_id`) VALUES
(1, 1),
(1, 2),
(2, 3);

-- --------------------------------------------------------
--
-- Dumping data for table `traoption`
--

INSERT INTO `traoption` (`id`, `name`, `point`, `sort_order`) VALUES
(1, 'At one of our practice locations', 0, 1),
(2, 'Off-site: At another clinical location (clinic, practice, hospital)', 0, 2),
(3, 'Off-site: Patient’s home or work', 0, 3),
(4, 'No/Unsure', 1, 1),
(5, 'Somewhat', 2, 2),
(6, 'Definitely', 3, 3),
(7, 'Not Applicable', 0, 4);

-- --------------------------------------------------------
--
-- Dumping data for table `question_traoption`
--

INSERT INTO `question_traoption` (`question_id`, `traoption_id`) VALUES
(1, 1),
(1, 2),
(1, 3);


-- --------------------------------------------------------
--
-- Dumping data for table `concept_traoption`
--

INSERT INTO `concept_traoption` (`concept_id`, `traoption_id`) VALUES
(1, 4),
(2, 4),
(3, 4),
(4, 4),
(5, 4),
(6, 4),
(7, 4),
(8, 4),
(9, 4),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5),
(6, 5),
(7, 5),
(8, 5),
(9, 5),
(10, 5),
(11, 5),
(12, 5),
(13, 5),
(1, 6),
(2, 6),
(3, 6),
(4, 6),
(5, 6),
(6, 6),
(7, 6),
(8, 6),
(9, 6),
(10, 6),
(11, 6),
(12, 6),
(13, 6),
(1, 7),
(2, 7),
(3, 7),
(4, 7),
(5, 7),
(6, 7),
(7, 7),
(8, 7),
(9, 7),
(10, 7),
(11, 7),
(12, 7),
(13, 7);

