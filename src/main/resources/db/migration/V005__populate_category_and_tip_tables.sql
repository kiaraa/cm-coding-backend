INSERT INTO tip_category_entity(name)
VALUES ('General Exam Tips'),
('Business of Medicine'),
('Anatomy and Medical Terminology'),
('ICD-10'),
('CPT/HCPCS'),
('Integumentary System'),
('Musculoskeletal System'),
('Respitory and Hem/Lymph Systems, Mediastinum/Diaphragm'),
('Cardiovascular System'),
('Digestive System'),
('Urinary and Male Genital Systems'),
('Female Reproductive System and Maternity Care/Delivery'),
('Endocrine and Nervous Systems'),
('Special Senses (Eye and Ear)'),
('Anesthesia'),
('Radiology'),
('Path and Lab'),
('E/M'),
('Medicine');

ALTER TABLE tip_entity MODIFY tip VARCHAR(10000);

SET @cat_id= (SELECT id FROM tip_category_entity where name='General Exam Tips');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Figure out which concept you are stronger at- ICD-10 or CPT/HCPCS.'),
(@cat_id, 'When looking at multiple choice questions, when given the option, start with that concept first- approach each question the same way as repetition builds speed.'),
(@cat_id, 'When looking at a question underline all of the “important”/descriptive” words- practice this as it will help to gain time as you should not have to read the question twice. After an answer has been chosen, just double check that the underlined words are in the answer.'),
(@cat_id, 'Diagnoses- diabetes with retinopathy, aortic stenosis, prostate cancer.'),
(@cat_id, 'Location- arm, knee, abdominal.'),
(@cat_id, 'Type of procedure- repair, excision, bypass graft.'),
(@cat_id, 'Words to further describe the procedure- complex, simple, excisional.'),
(@cat_id, 'Do process of elimination-
Example if you have all ICD-10 codes look and see which ones are the closet and attack those first. Then eliminate the answers with the diagnosis that does not make sense. Continue this process until you have captured the correct answer with the underlined words in your question.
Example if ICD-10 is your strong concept, begin your elimination process with ICD-10. If you have two diagnoses, look up those diagnosis and eliminate the answers that have the diagnosis that does not make sense. Then attack the CPT codes for the answers with the correct diagnoses.
Example if you have all CPT codes look and see which ones are the closet and attack those first. Then eliminate the answers with the code that does not make sense. Continue this process until you have captured the correct answer with the underlined words from your question.'),
(@cat_id, 'Do not go in order- start with those subjects that are easier (for example Business of Medicine-what is HIPPA and what is an OIG workplan) and Anatomy and Medical Terminology. This will allow you to gain time needed to answer the more difficult questions (for example Cardiovascular and E/M)');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Business of Medicine');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Document all the items not familiar with in a place where you can remember (make sure that it is tabbed).'),
(@cat_id, 'Insurance- learn the different types of payers- Government payors (Medicare Part A-D and Medicaid) vs Commercial payers (Blue Cross).'),
(@cat_id, 'Medical Record- learn what SOAP notes are- Subjective, Objective, Assessment and Plan.'),
(@cat_id, 'Learn acronyms, the meaning and dates enacted - for example HIPPA (Health Insurance Portability and Accountability Act), ABN (Advance Beneficiary Notice).'),
(@cat_id, 'Operative Report Documentation and what is included.'),
(@cat_id, 'Code of Ethics for the AAPC'),
(@cat_id, 'What is Medical Necessity'),
(@cat_id, 'Quality Payment Programs- MIPS (Merit-Based Incentive Payment System) and APM (Advanced Alternative Payment Model)'),
(@cat_id, 'What is the OIG workplan- how often is it updated?');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Anatomy and Medical Terminology');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Always refer to the anatomy and medical terminology for any subject as this is a starting point for each chapter.'),
(@cat_id, 'There are colorful illustrations in both the ICD-10 and HCPS to assist.'),
(@cat_id, 'Get a plastic Anatomy Chart from a college book store or order it online- for example Quick Study Academic Anatomy Chart (this chart goes into additional detail regarding each system).');

SET @cat_id= (SELECT id FROM tip_category_entity where name='ICD-10');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Know the difference between the Alpha Index (this is where you look up your diagnosis) and the Tabular List (this is where you verify).'),
(@cat_id, 'ICD-10 Conventions- make sure you understand for example “see also”, “use additional code”. “code first” and Excludes 1 and Excludes 2.'),
(@cat_id, 'Guidelines per chapter- these do not have to be memorized, however an asterisk* or star or some other indication by a code that has a guideline would help.'),
(@cat_id, 'General guidelines- acute vs chronic conditions, laterality.'),
(@cat_id, 'Make sure to read the notes at the beginning of each section or under the code (always look around the code for additional info).'),
(@cat_id, 'Infections, Neoplasms and Injuries are a part of any subject (you can get an infection or neoplasms in any area of your body) get familiar with these chapters.'),
(@cat_id, 'Neoplasm Table- and what the headers mean- Malignant Primary vs Secondary, CA in situ, Uncertain vs Unspecified behavior, table should be tabbed.'),
(@cat_id, 'Table of Drugs- get familiar with this table and what the headers mean- Poisoning Accidental vs Assault vs self-harm, Adverse effect, etc., this table should be tabbed.'),
(@cat_id, 'Index to External Causes of Injuries- get familiar with this section.'),
(@cat_id, 'I practiced looking up diseases by finding conditions or issues that myself or a family member has- remember to start with your Main Term for example Pneumonia then get more specific (what kind of pneumonia) follow the indentations.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='CPT/HCPCS');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'the CPT book consists of tests, procedures (major and minor), anesthesia codes, evaluation and management codes. HCPCS book consists of durable medical equipment, drugs and other resources (What can be done to help resolve your issue and do you need any additional support?).'),
(@cat_id, 'Get the lay of the land- Look at the front and back flaps of both books.'),
(@cat_id, 'CPT- tab the Appendices on Modifiers, Vascular Families, Category II (codes end in “F” and Category III (codes end in “T”) codes and Place of Service codes:
	-If there are tabs given, use them to tab each chapter.
	-There are illustrations in each chapter that may be helpful.
	-Make sure to read your parenthetical instructions .
	-Initially read the headers under each section to highlight any pertinent info (info you feel may be needed to answer a question, for example.'),
(@cat_id, 'HCPCS- tab the Table of Drugs and Chemicals, Appendices for Modifiers and Place of Service codes.'),
(@cat_id, 'Anything before the semicolon is considered the parent code. Anything after the semicolon can change (pay attention to indentions).'),
(@cat_id, 'Evaluation and Management- get familiar with the E/M tables the front of the book.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Integumentary System');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines (by putting an asterisk or star next to them).'),
(@cat_id, 'Excisions Benign or Malignant- make sure to read and highlight under the sections info that can be used to pick the correct code (for example if it is appropriate to report a bill a closure after an excision).'),
(@cat_id, 'Repairs- closures of wounds (length x width)
	-Highlight the definitions-Simple, Intermediate and Complex repairs.
	-Highlight under Repair (Closure)- wound closure utilizing adhesive strips as the sole repair material should be coded using the appropriate E/M.
	-Put the conversion table from mm/in to cm in your CPT book on the notes page for this chapter.
	-Highlight under each section- add the sum of lengths of repairs for each group of anatomic within each section.'),
(@cat_id, 'Burns- look up a video on youtube.com for the “Rule of Nines” to help calculate burn percentages.'),
(@cat_id, 'Mohs Micrographic Surgery:
	-Read the info under this section and highlight any pertinent info.
	-Pay close attention to the stages and blocks of these codes.
		-If there is more than one stage performed on a particular area then and add on code must be used.
		-If there is more than five blocks performed on any stage then add on code 17315 must be used.
	-As always pay close attention to the parenthetical instructions.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Musculoskeletal System');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines (by putting an asterisk or star next to them).'),
(@cat_id, 'Types of fractures- open, closed, displaced (default if not documented) and non-displaced.'),
(@cat_id, 'Types of treatment- highlight and become familiar with the definitions- Closed (default if not documented) and Open Treatment, Percutaneous skeletal fixation, Manipulation, Excisions and Radical resections.'),
(@cat_id, 'Eponymous of Fractures-  for example: get familiar with them Nursemaids- elbow, Hil-Sach- shoulder, Duverney (pelvic), Chance- vertebral, Cotton-ankle, Colles- wrist, Charot- foot, Monteggia- forearm, Slater-Harris- growth plate, etc.'),
(@cat_id, 'Know the differences between a cast, strapping, fracture treatment');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Respitory and Hem/Lymph Systems, Mediastinum/Diaphragm');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines (by putting an asterisk or star next to them).'),
(@cat_id, 'Lung Transplant- highlight the 3 stages Removal, Backbench work and Insertion.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Cardiovascular System');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'ICD-10- make sure to reread the guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines:
	-Assume a causal relationship between hypertension and heart failure and chronic kidney disease.
	-“Native” coronary artery is the default (you are born with it).
	-Myocardial Infarctions (MI)- initial, subsequent, old (greater than 4 weeks old).'),
(@cat_id, 'CPT- tab App. L Vascular Families.'),
(@cat_id, 'Anatomy of the Heart- know the definitions epicardium, myocardium and endocardium.'),
(@cat_id, 'Remember veins are blue and arteries are red.'),
(@cat_id, 'Sinoatrial node is also called Nature’s Pacemaker.'),
(@cat_id, 'Know the standard blood pressure 120/80 (Systolic/Diastolic)'),
(@cat_id, 'Additional Resources in this chapter- tab Central Venous Access Procedures Table, ECMO Procedures Grid, Procedure List Pacemaker vs implantable Defib'),
(@cat_id, 'Blood Flow list (how blood flows through the heart)- write down on the notes page for this chapter.'),
(@cat_id, 'Central Venous Access Procedures- highlight the different types of devices Insertion, Repair, Partial replacement, Complex replacement and Removal'),
(@cat_id, 'Dialysis Circuit- highlight and get familiar with the different types of segments/circuits/regions Transcatheter Procedures- highlight and underline the Arterial and Venous Mechanical Thrombectomy'),
(@cat_id, 'Endovascular Revascularization-highlight the hierarchy of complexity-- atherectomy and stent placement>atherectomy>stent placement>angioplasty'),
(@cat_id, 'Cardiac Valve- highlight and underline the different valves under the Aortic, Mitral, Pulmonary, Tricuspid'),
(@cat_id, 'Heart/Lung Transplant- highlight the 3 stages of a transplant Removal Backbench work and Insertion'),
(@cat_id, 'Coronary Artery Bypass- highlight and underline the different sections Venous Grafting, Combined Arterial-Venous and Arterial Grafting'),
(@cat_id, 'Under each of these sections read the notes underneath and highlight what veins/arteries that are procured are included.'),
(@cat_id, 'Under each of these sections read the notes underneath and highlight what vein/arteries that are harvested should be coded separately.'),
(@cat_id, 'Under each of these sections read the notes underneath and highlight that two codes must be coded for both the Combined Arterial-Venous and Arterial Grafting sections.'),
(@cat_id, 'Pacemaker (regulates your heart) and Implantable Defibrillator (shocks/restarts your heart)- Learn the difference between them.'),
(@cat_id, 'Pulse generator= battery'),
(@cat_id, 'Electrodes= leads'),
(@cat_id, 'These devices can be temporary or permanent.'),
(@cat_id, 'These devices can be single, dual, multiple leads or be leadless- highlight these definitions'),
(@cat_id, 'Bone Marrow or Stem Cell Services- highlight under the header that codes 38207-38215 may be reported only once per day.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Digestive System');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Urinary and Male Genital Systems');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Female Reproductive System and Maternity Care/Delivery');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Endocrine and Nervous Systems');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Special Senses (Eye and Ear)');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines.');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Anesthesia');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'Write the way to calculate anesthesia time at the beginning of the chapter
                  Base Value
                  +Time (divided in increments of 15 minutes)
                  +Additional units (for insurances other than Medicare)
                  Total x Conversion Factor (can be $25-$100)'),
(@cat_id, 'Physical Status Modifiers and the Qualifying Circumstances- get familiar and write the unites for each in your book'),
(@cat_id, 'Know the organs in the Intraperitoneal vs the Extraperitoneal (retroperitoneal) this will help to find the code ');

SET @cat_id= (SELECT id FROM tip_category_entity where name='Path and Lab');

INSERT INTO tip_entity (category, tip)
VALUES (@cat_id, 'These codes are "all or nothing" if there is a test not included in the code each test must be coded separately');
