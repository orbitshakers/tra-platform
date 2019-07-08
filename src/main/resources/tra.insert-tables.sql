-- --------------------------------------------------------
--
-- Dumping data for table `concept`
--

INSERT INTO `concept` (`id`, `name`, `explanation`, `instruction`, `unnamed`, `weight_perc`, `sort_order`) VALUES
(1, 'Need for Telehealth', 'Consider your practice’s needs with respect to telehealth.', 'Please select one circle in each row', 0, '10.00', 1),
(2, 'Organizational Leadership Buy-In', 'Consider whether your practice has support and direction from leadership.', 'Please select one circle in each row', 0, '10.00', 2),
(3, '3-unnamed', 'Consider the financial implications of telehealth, including costs and reimbursement, for your practice.', 'Please select one circle in each row', 1, '15.00', 1),
(4, 'Telehealth Roles', 'Consider the roles and responsibilities needed for telehealth.', 'Please select one circle in each row', 0, '5.00', 1),
(5, 'Scheduling and Workflows', 'Consider how your practice will schedule telehealth visits and what the associated workflow will be for the visits.', 'Please select one circle in each row', 0, '10.00', 2),
(6, 'Operational Requirements', 'Consider the operational requirements for telehealth for your practice.', 'Please select one circle in each row', 0, '5.00', 3),
(7, 'Assessment Approach', 'Consider how your practice will monitor and assess implementation/outcomes.', 'Please select one circle in each row', 0, '5.00', 4),
(8, 'Technology', 'Consider the technical infrastructure needed for telehealth in your practice.', 'Please select one circle in each row', 0, '10.00', 5),
(9, 'Physical Space', 'Consider what facilities are needed for telehealth in your practice.', 'Please select one circle in each row', 0, '5.00', 6),
(10, 'Education and Awareness', 'Consider how to increase awareness and engagement among staff.', 'Please select one circle in each row', 0, '7.50', 1),
(11, 'Innovators/Champions', 'Consider who at your practice will support telehealth.', 'Please select one circle in each row', 0, '7.50', 2),
(12, 'Patient Engagement', 'Consider how your practice will engage patients in telehealth services.', 'Please select one circle in each row', 0, '5.00', 1),
(13, 'Health Literacy', 'What is your patient population’s capacity to obtain, process and understand basic health information needed to make appropriate health decisions?', 'Please select one circle in each row', 0, '5.00', 2);

-- --------------------------------------------------------
--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`id`, `name`, `instruction`, `weight_perc`, `sort_order`) VALUES
(1, 'Core Readiness', NULL, '20.00', 1),
(2, 'Financial Considerations', NULL, '15.00', 2),
(3, 'Operations', NULL, '40.00', 3),
(4, 'Staff Engagement', NULL, '15.00', 4),
(5, 'Patient Readiness', NULL, '10.00', 5);

-- --------------------------------------------------------
--
-- Dumping data for table `question_type`
--

INSERT INTO `question_type` (`id`, `name`) VALUES
(2, 'CONCEPT'),
(3, 'FEEDBACK'),
(1, 'STANDALONE');

-- --------------------------------------------------------
--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `name`, `title`, `question_type_id`, `multi_answer`, `explanation`, `instruction`, `text`, `sort_order`) VALUES
(1, 'Usecase', 'How Does/Will Your Practice Use TeleHealth?', 1, 1, 'Small physician practices can use telehealth in a variety of ways. For example, primary care physicians may use telehealth to provide their patients with access to off-site specialists. Providers may use telehealth to offer counseling or follow-up services to patients located in their home or office. <br><br> As you complete this tool, please think about how your practice uses or is considering telehealth services.', 'Select all that apply.', 'Where will <b>patients</b> be located during telehealth visits?', 1),
(2, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice have difficulty getting the medical care they need because providers are too far away, patients lack transportation, or patients are unable to leave work or home?', 1),
(3, NULL, NULL, 2, 0, NULL, NULL, 'Has your organization identified specific types of patients or clinical needs that may benefit from using telehealth?', 2),
(4, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice ask for telehealth services or express interest in aspects of telehealth such as remote visits?', 3),
(5, NULL, NULL, 2, 0, NULL, NULL, 'Do patients in your practice use or express a need or desire for after-hours (evenings and weekends) medical care?', 4),
(6, NULL, NULL, 2, 0, NULL, NULL, 'Do providers affiliated with your practice routinely travel over 30 minutes from their primary location to provide services in other locations?', 5),
(7, NULL, NULL, 2, 0, NULL, NULL, 'Do the potential benefits of telehealth for your practice outweigh the potential challenges associated with telehealth?', 6),
(8, NULL, NULL, 2, 0, NULL, NULL, 'Is your practice''s leadership committed to telehealth development efforts?', 1),
(9, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified the vision, priorities, and goals for implementing telehealth?', 2),
(10, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice created a telehealth business plan?', 3),
(11, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice’s leadership had past successes with instituting programs that required complex change processes, such as quality improvement initiatives or electronic health record implementations?', 4),
(12, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how it will fund any capital costs (e.g., equipment, software, licensing) needed to start a telehealth program?', 1),
(13, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified what additional staffing costs, if any, are needed to implement and maintain a telehealth program?', 2),
(14, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice examined the telehealth services reimbursement policies for major insurers (Medicare/Medicaid, and private insurance)?', 3),
(15, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered whether it would be financially feasible to offer telehealth services that are reimbursed by some but not all insurers?', 4),
(16, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice gathered the necessary information to conduct a cost, benefit, and risk analysis of implementing and using telehealth?', 5),
(17, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined the staff responsibilities required to manage the administrative aspects of telehealth such as appointment scheduling, coordinating information across providers, and patient documentation?', 1),
(18, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined the staff responsibilities required to support telehealth patients, such as having a dedicated telehealth contact person to explain telehealth, answer patient questions, and provide assistance during telehealth appointments?', 2),
(19, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined what, if any, additional telehealth staffing support is needed to implement and maintain a telehealth program?', 3),
(20, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined how to protect staff time that needs to be dedicated to their telehealth roles and responsibilities?', 4),
(21, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how administrative workflows (scheduling, billing, patient documentation, communication between staff) will need to change to incorporate telehealth?', 1),
(22, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how clinical workflows (e.g., taking vital signs, ordering labs, writing prescriptions) will need to change to incorporate telehealth services?', 2),
(23, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how care for telehealth patients will be coordinated and communicated across providers?', 3),
(24, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined how to obtain and document the patient’s consent prior to receiving telehealth services?', 4),
(25, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how telehealth services will fit within your practice’s workflow with respect to when telehealth services are offered (e.g., follow-up care vs treatment, referral vs. self-referral, after hours vs. regular hours)?', 5),
(26, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined state licensing requirements necessary for each provider type (e.g., physician, nurse, PA) implementing telehealth services?', 1),
(27, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice evaluated privacy and confidentiality procedures for telehealth services and how these conform to patient health protection laws (e.g., HIPAA; 42 CFR-Part II)?', 2),
(28, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined potential telehealth malpractice insurance coverage and liability costs?', 3),
(29, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice determined whether any additional credentialing processes are needed for providers to provide telehealth services?', 4),
(30, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered what the \"success factors\" for telehealth are such as cost effectiveness, patient/provider satisfaction, improved patient outcomes?', 1),
(31, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how staff and patients will provide feedback on the telehealth program and how it is working?', 2),
(32, NULL, NULL, 2, 0, NULL, NULL, 'Does your practice have tools or methods in place for soliciting feedback from providers, staff and patients that could be used or adapted for telehealth?', 3),
(33, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered the need for making improvements to services and administrative procedures based on feedback from providers, staff, and patients?', 4),
(34, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice reviewed or tested different telehealth equipment, software or services?', 1),
(35, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified what types of telecommunication connections (e.g., bandwidth and internet connectivity quality) are needed to support telehealth at both originating and distant sites?', 2),
(36, NULL, NULL, 2, 0, NULL, NULL, 'Have staff at your practice been involved in reviewing or selecting the technology?', 3),
(37, NULL, NULL, 2, 0, NULL, NULL, 'Does your practice have existing IT staff or an IT vendor that provides technical expertise, technical support and troubleshooting?', 4),
(38, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified a designated space for virtual patient visits with an appropriate layout, privacy, and adequate lighting that will enable a distant provider to do a clinical assessment?', 1),
(39, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified the requirements for physical space and equipment at the provider’s site to ensure quality and privacy? For example, has your practice considered whether providers will consult from their office or a designated telehealth room?', 2),
(40, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered emergency protocols for telehealth patients?', 3),
(41, NULL, NULL, 2, 0, NULL, NULL, 'Are your staff aware of telehealth and the potential benefits and challenges involved in implementing a program?', 1),
(42, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how to ensure provider engagement in telehealth services once they’re implemented?', 2),
(43, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered how much time (calendar time and staff time) will be devoted to training staff and providers (particularly those who are less tech-savvy) on telehealth services?', 3),
(44, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice identified one or more provider champions within the practice who are enthusiastic for telehealth and can keep the process moving forward once started?', 1),
(45, NULL, NULL, 2, 0, NULL, NULL, 'Are clinical staff at your practice interested in and willing to use telehealth technology for client services?', 2),
(46, NULL, NULL, 2, 0, NULL, NULL, 'Do any of the staff at your practice have experience with telehealth services?', 3),
(47, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice solicited interest and input on implementing telehealth from clinical staff and administrative staff within your practice?', 4),
(48, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered whether telehealth could be used to increase patient engagement in managing their health and making healthcare decisions?', 1),
(49, NULL, NULL, 2, 0, NULL, NULL, 'When your practice has implemented technologies aimed at patients (e.g., patient portals, text reminders, online scheduling) have your patients used them? [If you have not implemented any technology aimed at patients, answer Not Applicable.]', 2),
(50, NULL, NULL, 2, 0, NULL, NULL, 'Does your practice have existing mechanisms in place that can be used or adapted to conduct education and outreach about telehealth to the target population?', 3),
(51, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered what additional methods might be needed to conduct education and outreach about telehealth to the target population?', 4),
(52, NULL, NULL, 2, 0, NULL, NULL, 'Has your practice considered patient demographics and cultural issues that could influence implementing telehealth?', 5),
(53, NULL, NULL, 2, 0, NULL, NULL, 'Have you considered your patients'' perceived needs and motivations for telehealth to determine how telehealth can best benefit them?', 1),
(54, NULL, NULL, 2, 0, NULL, NULL, 'Have you considered how well your patients comprehend health information and whether telehealth would help or hinder that?', 2),
(55, NULL, NULL, 2, 0, NULL, NULL, 'Have you considered surveying patients to learn what types of telehealth services patients need, how important certain telehealth services are, or how best to implement telehealth?', 3);

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
(2, 11),
(3, 12),
(3, 13),
(3, 14),
(3, 15),
(3, 16),
(4, 17),
(4, 18),
(4, 19),
(4, 20),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(5, 25),
(6, 26),
(6, 27),
(6, 28),
(6, 29),
(7, 30),
(7, 31),
(7, 32),
(7, 33),
(8, 34),
(8, 35),
(8, 36),
(8, 37),
(9, 38),
(9, 39),
(9, 40),
(10, 41),
(10, 42),
(10, 43),
(11, 44),
(11, 45),
(11, 46),
(11, 47),
(12, 48),
(12, 49),
(12, 50),
(12, 51),
(12, 52),
(13, 53),
(13, 54),
(13, 55);

-- --------------------------------------------------------
--
-- Dumping data for table `domain_concept`
--

INSERT INTO `domain_concept` (`domain_id`, `concept_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(4, 10),
(4, 11),
(5, 12),
(5, 13);

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
(1, 5),
(1, 6),
(1, 7),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(4, 4),
(4, 5),
(4, 6),
(4, 7),
(5, 4),
(5, 5),
(5, 6),
(5, 7),
(6, 4),
(6, 5),
(6, 6),
(6, 7),
(7, 4),
(7, 5),
(7, 6),
(7, 7),
(8, 4),
(8, 5),
(8, 6),
(8, 7),
(9, 4),
(9, 5),
(9, 6),
(9, 7),
(10, 4),
(10, 5),
(10, 6),
(10, 7),
(11, 4),
(11, 5),
(11, 6),
(11, 7),
(12, 4),
(12, 5),
(12, 6),
(12, 7),
(13, 4),
(13, 5),
(13, 6),
(13, 7);
