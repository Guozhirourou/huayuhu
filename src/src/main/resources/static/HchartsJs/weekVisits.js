Highcharts.setOptions({
<<<<<<< HEAD
    global: {
        useUTC: false
    }
});
function activeLastPointToolip(chart) {
    var points = chart.series[0].points;
    chart.tooltip.refresh(points[points.length -1]);
}
var chart = Highcharts.chart('weekVisits', {
    chart: {
        type: 'spline',
        marginRight: 10,
        events: {
            load: function () {
                var series = this.series[0],
                    chart = this;
                activeLastPointToolip(chart);
                setInterval(function () {
                    var x = (new Date()).getTime(), // 当前时间
                        y = Math.floor(Math.random()*200);          // 随机值
                    series.addPoint([x, y], true, true);
                    activeLastPointToolip(chart);
                }, 1000);
            }
        }
    },
    title: {
        text: '平台实时访问量'
    },
    xAxis: {
        type: 'datetime',
        tickPixelInterval: 150
    },
    yAxis: {
        title: {
            text: null
        }
    },
    tooltip: {
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                Highcharts.numberFormat(this.y, 2);
        }
    },
    legend: {
        enabled: false
    },
    series: [{
        name: '实时访问量',
        data: (function () {
            // 生成随机值
            var data = [],
                time = (new Date()).getTime(),
                i;
            for (i = -19; i <= 0; i += 1) {
                data.push({
                    x: time + i * 1000,
                    y: Math.round(Math.random()*200)
                });
            }
            return data;
        }())
    }]
=======
	global: {
		useUTC: false
	}
});
function activeLastPointToolip(chart) {
	var points = chart.series[0].points;
	chart.tooltip.refresh(points[points.length -1]);
}
var chart = Highcharts.chart('weekVisits', {
	chart: {
		type: 'spline',
		marginRight: 10,
		events: {
			load: function () {
				var series = this.series[0],
					chart = this;
				activeLastPointToolip(chart);
				setInterval(function () {
					var x = (new Date()).getTime(), // 当前时间
						y = Math.random();          // 随机值
					series.addPoint([x, y], true, true);
					activeLastPointToolip(chart);
				}, 1000);
			}
		}
	},
	title: {
		text: '实时访问量'
	},
	xAxis: {
		type: 'datetime',
		tickPixelInterval: 150
	},
	yAxis: {
		title: {
			text: null
		}
	},
	tooltip: {
		formatter: function () {
			return '<b>' + this.series.name + '</b><br/>' +
				Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
				Highcharts.numberFormat(this.y, 2);
		}
	},
	legend: {
		enabled: false
	},
	series: [{
		name: '随机数据',
		data: (function () {
			// 生成随机值
			var data = [],
				time = (new Date()).getTime(),
				i;
			for (i = -19; i <= 0; i += 1) {
				data.push({
					x: time + i * 1000,
					y: Math.random()
				});
			}
			return data;
		}())
	}]
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
});