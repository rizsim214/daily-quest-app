    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <script src="<s:url value='../../../../assets/javascript/main.js/>"></script>
    <script>
        $(document).ready( function () {
            $('#transaction_quest').DataTable({
                scrollY: 400,
                ordering: true
            });
            $('#posted_quest_history').DataTable({
                scrollY: 400,
                ordering: true
            });
            $('#accepted_quest_history').DataTable({
                scrollY: 400,
                ordering: true
            });
        });
        
    </script>
</body>
</html>
