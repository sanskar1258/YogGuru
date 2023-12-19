<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>:: TDF Home ::</title>
    
    <link rel="icon" href="static/images/tdf_logo.ico">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container-fluid">
        <!-- ############################### -- Header -- ###################################-->
        <c:import url="header.jsp" />
        
        <!-- ############################### -- Page Body -- ###################################-->
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <div class="container mt-5">
                    <form action="add_member.do" method="post">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div><br>
                        <div class="form-group">
                            <label for="age">Age:</label>
                            <input type="number" class="form-control" id="age" name="age" required>
                        </div><br>
                        <div class="form-group">
                            <label for="number">Phone Number:</label>
                            <input type="tel" class="form-control" id="number" name="number" required>
                        </div><br>
                        <div class="form-group">
                            <label for="start_date">Start Date:</label>
                            <input type="date" class="form-control" id="start_date" name="start_date" required>
                        </div><br>
                        
                        <div class="form-group">
                            <label for="selectedBatch">Select Batch:</label>
                            <select class="form-control" id="selectedBatch" name="selectedBatch" required>
                                <option value="6-7AM">6-7AM</option>
                                <option value="7-8AM">7-8AM</option>
                                <option value="8-9AM">8-9AM</option>
                                <option value="5-6PM">5-6PM</option>
                            </select>
                        </div><br>
                        <div class="d-grid gap-2 col-6 mx-auto">
                        <button type="submit" class="btn btn-primary">Add Member</button>
                        </div>
                    </form>
                </div>

            </div>
            <div class="col-1"></div>
        </div>
        
        <!-- ############################### -- Footer -- ###################################-->
        <c:import url="footer.jsp" />
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>