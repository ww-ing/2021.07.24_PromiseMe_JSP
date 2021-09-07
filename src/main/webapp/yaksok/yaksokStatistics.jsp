<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Load c3.css -->
	<link href="yaksok/css/c3.min.css" rel="stylesheet">

    <script>
    var chart = c3.generate({
        bindto: '#chartMonth',
        data: {
          columns: [
            ['이번 달', 0, 200, 100, 400, 150, 250, 100, 111, 122, 140, 105, 110, 220, 150, 250, 100, 111, 122, 140, 105, 110, 220, 150, 250, 100, 111, 122, 140, 105, 110, 220]
          ]
        }
    });
    
    var chart = c3.generate({
        bindto: '#chartYear',
        data: {
          columns: [
            ['2020', 0, 70, 120, 400, 250, 250, 200, 411, 222, 640, 305, 410, 700],
            ['2021', 0, 120, 320, 200, 150, 550, 400, 111, 292, 440, 105, 910, 200]
          ]
        }
    });
    
    var chart = c3.generate({
    	bindto: '#pie',
        data: {
            columns: [
                ['1회 예약', 60],
                ['2회 이상 예약', 120],
            ],
            type : 'pie',
            onmouseover: function (d, i) { console.log("onmouseover", d, i); },
            onmouseout: function (d, i) { console.log("onmouseout", d, i); }
        }
    });

    
    
    </script>
				<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <br>
                    <h1 class="h3 mb-2 text-gray-800">통계</h1><br>

                    <!-- Content Row -->
                    <div class="row">

                        <div class="col-xl-8 col-lg-7">

                            <!-- Area Chart -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">9 월</h6>
                                </div>
                                <div class="card-body">
                                    <div class="chart-area">
                                        <!-- <canvas id="myAreaChart"></canvas> -->
                                        <div id="chartMonth"></div>
                                        <hr>
                                       	월 별 예약 통계를 보여줍니다.
                                    </div>
                                </div>
                            </div>

                            <!-- Bar Chart -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">2021 년</h6>
                                </div>
                                <div class="card-body">
                                    <div class="chart-area">
                                        <!-- <canvas id="myBarChart"></canvas> -->
                                        <div id="chartYear"></div>
                                    </div>
                                    <hr>
                                    해당 연도와 전년도의 예약 통계를 비교합니다.
                                </div>
                            </div>

                        </div>

                        <!-- Donut Chart -->
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">중복 예약 통계</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4">
                                        <!-- <canvas id="myPieChart"></canvas> -->
                                        <div id="pie"></div>
                                    </div>
                                    <hr>
                                    전체 예약중 1회 예약 비율과 2회 이상 예약한 통계를 보여줍니다.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->