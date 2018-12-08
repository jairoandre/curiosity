var urlParams = new URLSearchParams(window.location.search);
var queryDate = urlParams.get('date');
var marReportVue = new Vue({
    el: '#mars-report',
    data () {
        return {
            date: '2018-04-01',
            weather: null
        }
    },
    methods: {
        load: function() {
            axios.get('/api/mars/report/' + this.date).then(r => {
                this.weather = r.data;
            });
        }
    },
    mounted () {
        if (queryDate)
            this.date = queryDate;
        this.load();
    }
});

var nasaPic = new Vue({
    el: '#nasa-pic',
    data () {
        return {
            date: '2018-04-01',
            currentIdx: 0,
            photos: []
        }
    },
    mounted () {
        if (queryDate)
            this.date = queryDate;
        this.load();
    },
    methods: {
        load: function () {
            this.photos = [];
            var apiUrl = '/api/mars/photos/' + this.date;
            axios(apiUrl).then(r => this.photos = r.data);
        },
        next: function ()  {
            this.currentIdx += 1;
            if (this.currentIdx >= (this.photos.length - 1))
                this.currentIdx = 0;
        },
        previous: function () {
            this.currentIdx -= 1;
            if (this.currentIdx < 0)
                this.currentIdx = this.photos.length - 1;
        }
    }
});





