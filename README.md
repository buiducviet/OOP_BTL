App có các giao diện sau: - Giao diện chính có list các quiz
								+ Có button "Home" có thể nhấn để quay trở về giao diện này
								+ Có chức năng xóa quiz bằng cách nhấn chuột phải vào quiz và nhấn nút Delete
								
						  - Giao diện tạo quiz mới ( xuất hiện khi nhấn vào nút TURN ON EDITING ở giao diện chính)
						  		+ Tạo quiz theo dữ liệu người dùng nhập vào, nếu quiz có tên trùng với tên của quiz đã tồn tại thì 
						  		  sẽ đưa ra cảnh bảo
						  		+ Tháng và năm đang được để cố định.
						  		
						  - Giao diện Questions có được khi nhấn vào Questions trong giao diện popup(nhấn vào nút cài đặt của giao diện chính)
						  		+ Có thể chọn các QuestionBank và xóa câu hỏi bất kì trong QuestionBank đó, đồng thời có thể xóa QuestionBank đã có
						  - Giao diện tạo category mới có được khi nhấn vào tab Categories bên cạnh tab Questions
						  		+ Tạo category mới là con của 1 category nào đó tùy chọn
						  		+ Category mới k được trùng tên với category đã có, nếu trùng sẽ đưa ra cảnh báo không hợp lệ
						  - Giao diện Import khi nhấn với tab Import
						  		+ Có thể tải file lên bằng nút CHOOSE A FILE (chỉ file .txt hoặc .docx và đúng định dạng Aiken)
						  		+ Ngoài ra có thể trực tiếp thả file vào vùng 
						  		+ Nếu file không đúng định dạng sẽ đưa ra cảnh báo lỗi tại dòng thứ bao nhiêu ( chưa được chính xác )
						  		+ Nếu file đúng định dạng và không có tên trùng với tên của QuestionBank đã có thì file sẽ trở thành 1 QuestionBank mới
						  - Giao diện tạo câu hỏi có được khi click vào nút CREAT A NEW QUESTION
						  		+ Tạo câu hỏi nằm trong 1 category nào đó tùy chọn 
						  		+ Tên câu hỏi không được trùng với tên câu hỏi đã có trong category đó
						  		+ Có thể tải ảnh lên câu hỏi 
						  		+ Câu hỏi có ít nhất 2 đáp án và nhiều nhất 5 đáp án, có thể có multiple choices(chưa thêm) với các mức điểm tùy chọn, điểm tối đa cho 1 câu hỏi đang là 1 điểm
						  - Giao diện quiz có được khi nhấn chuột phải vào quiz ở giao diện chính
						  		+ thể hiện những thông tin cơ bản của quiz (tên, thời gian, thông tin những lần đã thi )
						  - Giao diện edit quiz khi nhấn vào nút cài đặt ở giao diện quiz
						  		+ nhấn nút select multiple items để chọn nhiều câu hỏi ( cho thao tác delete )
						  - Giao diện add questions from question bank có được khi nhấn nút add -> from question bank 
						  		+ chọn 1 hoặc nhiều câu hỏi
						  		+ nếu trong số câu hỏi đã chọn, có câu hỏi đã có trong quiz thì sẽ chỉ thêm những câu hỏi không trùng và đưa ra thông báo
						  		
						  - Giao diện add random question khi nhấn vòa add -> a random question
						  		+ chọn cate -> chọn số câu hỏi muốn thêm -> thêm câu hỏi ( chưa fix câu hỏi trùng )
						  		+ mỗi page có 12 question và có thể chuyển page
						  - Popup "START ATTEMP"
						  		+ Nhấn nút Export sẽ in ra file .pdf nằm trong ổ C:\ (có thể fix thêm chọn nơi lưu trữ) và có thể đặt mật khẩu cho quiz ( chưa cài yêu cầu mật khẩu như thế nào )
						  		+ nút attempt sẽ chuyển sang giao diện thi
						  - Giao diện thi
						  		+ Thời gian là thời gian của quiz bạn đã tạo ở giao diện tạo quiz
						  		+ Nhấn chọn từng câu hỏi, trong câu hỏi có hình ảnh ( chưa có multiple choice )
						  		+ nút finish attempt sẽ kết thúc phần thi và đưa ra kết qua bạn đạt bao nhiêu câu / tổng số câu hỏi
						  		+ (chưa thêm ) khi nhấn finish thì sẽ trở lại giao diện quiz và thể hiện phần attempt ở giao diện đó, đồng thời chon review quiz
						  		
						  		
+NHỮNG PHẦN CÒN THIẾU : 
						  - Multiple choices ( trong phần thi chưa có , làm khá rắc rối ).
						  - phần hình ảnh trong file docx import vào
						  - in ra file pdf có chứa hình ảnh
						  - phần điểm chưa được như ý
						  - phần edit question ( done 90 % )
						  - một vài phần nhỏ khác.						
						  		
						  		
						  